package com.nt.scms2.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;


@Service
public class SpeechService {
	
	
	@Value("${player.path}")
	private String playerPath; 
	
	public void sayIt(String text) throws Exception {
		
		System.out.println(LocalDateTime.now() + " Say it : " + text);
		
		// Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Set the text input to be synthesized
	      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

	      // Build the voice request, select the language code ("en-US") and the ssml voice gender
	      // ("neutral")
	      VoiceSelectionParams voice =
	          VoiceSelectionParams.newBuilder()
	              .setLanguageCode("pt-BR")
	              .setSsmlGender(SsmlVoiceGender.NEUTRAL)
	              .build();

	      // Select the type of audio file you want returned
	      AudioConfig audioConfig =
	          AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

	      // Perform the text-to-speech request on the text input with the selected voice parameters and
	      // audio file type
	      SynthesizeSpeechResponse response =
	          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
	      
	      // Get the audio contents from the response
	      ByteString audioContents = response.getAudioContent();
	      
	      // Write the response to the output file.
	      
	      String nameFile = playerPath+"output.mp3";
	      try (OutputStream out = new FileOutputStream(nameFile)) {
	        out.write(audioContents.toByteArray());
	        System.out.println("Audio content written to file \"output.mp3\"");
	      }
	    }
	}
	
	public  Optional<Path> execMusic() throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get(playerPath))) {
    	    return  paths.filter(Files::isRegularFile).findFirst();
		}
	}
	
}
