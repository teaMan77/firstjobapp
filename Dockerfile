FROM openjdk:17
VOLUME /tmp
ADD target/firstjobapp-0.0.1-SNAPSHOT.jar firstjobapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/firstjobapp.jar"]