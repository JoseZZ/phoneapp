FROM openjdk:8-jdk-alpine
MAINTAINER JoseZZ
VOLUME /tmp
ADD target/*.jar phone-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/phone-service.jar"]

