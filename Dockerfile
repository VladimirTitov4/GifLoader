FROM openjdk:8-jdk-alpine

RUN mkdir app

COPY build/libs/gifloader-0.0.1-SNAPSHOT.jar /app/app.jar

COPY application.yml /app

RUN chmod ugo+x -R /app

ENTRYPOINT ["java","-jar","app/app.jar","--spring.config.additional-location=/app/application.yml"]