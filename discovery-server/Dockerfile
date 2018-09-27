FROM openjdk:8-jdk-alpine
MAINTAINER JoseZZ
VOLUME /tmp
ADD target/*.jar discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery-server.jar"]

