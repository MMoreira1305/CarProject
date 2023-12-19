FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY backend .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build ./backend/target/backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]