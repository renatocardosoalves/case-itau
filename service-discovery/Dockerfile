FROM openjdk:11
VOLUME "/tmp"
EXPOSE 8761
ADD build/libs/service-discovery-0.0.1-SNAPSHOT.jar service-discovery.jar
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]
