FROM openjdk:21-jdk-slim-buster
WORKDIR /notification

COPY build/libs/notification-api-1.0-SNAPSHOT.jar /notification/build/

WORKDIR /notification/build

EXPOSE 8080

ENTRYPOINT java -jar notification-api-1.0-SNAPSHOT.jar