FROM openjdk:11
COPY . /usr/ms1/
RUN apt-get update -y && apt-get install maven -y
RUN cd /usr/ms1/ && mvn clean install -DskipTests
RUN chmod +x /usr/ms1/wait-for-it.sh
CMD ["/usr/ms1/wait-for-it.sh", "rabbitmq:5672", "--", "java", "-jar", "-Dspring.profiles.active=prod", "/usr/ms1/target/nt-sc-ms1-0.0.1-SNAPSHOT.jar"]
EXPOSE 9091