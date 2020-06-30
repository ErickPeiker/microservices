FROM openjdk:11
COPY target/nt-sc-gw-*.jar app-gateway.jar
EXPOSE 9090
CMD ["java", "-jar", "/app-gateway.jar"] 