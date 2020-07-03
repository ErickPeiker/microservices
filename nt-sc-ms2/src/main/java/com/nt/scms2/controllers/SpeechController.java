package com.nt.scms2.controllers;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.scms2.services.SpeechService;

@Controller
public class SpeechController {
	
	@Autowired
	private SpeechService speechService;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@RequestMapping({"/nt-ms2/audio", "/nt-ms2"})
    public String index(final Model model) {
		return "index";
    }
	
	@GetMapping(value="/nt-ms2/audio/download")
    public Resource downloadFileWithGet() throws IOException {
		resourceLoader.getResource(location)
        return speechService.execMusic().get();	
    }

}
