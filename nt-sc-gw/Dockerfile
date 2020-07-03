FROM openjdk:11
COPY . /usr/gateway/
RUN apt-get update -y && apt-get install maven -y
RUN cd /usr/gateway/ && mvn clean install -DskipTests
EXPOSE 9090
CMD ["java", "-jar", "-Dspring.profiles.active=prod",  "/usr/gateway/target/nt-sc-gw-0.0.1-SNAPSHOT.jar"] 