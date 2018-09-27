FROM openjdk:8-jdk-alpine
MAINTAINER JoseZZ
VOLUME /tmp
ADD target/*.jar config-server.jar
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-server.jar"]

