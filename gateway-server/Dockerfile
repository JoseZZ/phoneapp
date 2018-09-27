FROM openjdk:8-jdk-alpine
MAINTAINER JoseZZ
VOLUME /tmp
ADD target/*.jar gateway-server.jar
EXPOSE 8084
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-server.jar"]

