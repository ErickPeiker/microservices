FROM openjdk:11
COPY . /usr/ms2/
RUN apt-get update -y && apt-get install maven -y
RUN cd /usr/ms2/ && mvn clean install -DskipTests
RUN chmod +x /usr/ms2/wait-for-it.sh
CMD ["/usr/ms2/wait-for-it.sh", "rabbitmq:5672", "--", "java", "-jar", "-Dspring.profiles.active=prod", "/usr/ms2/target/nt-sc-ms2-0.0.1-SNAPSHOT.jar"]
EXPOSE 9092
ENV GOOGLE_APPLICATION_CREDENTIALS=/usr/ms2/testes-recursos-132a2d80a12d.json
RUN mkdir sounds