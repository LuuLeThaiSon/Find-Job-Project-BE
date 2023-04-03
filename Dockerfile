#FROM gradle:jdk11 as builder
#COPY --chown=gradle:gradle . /app
#WORKDIR /app
#RUN gradle bootjar

FROM adoptopenjdk:11-jdk-hotspot
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
#RUN #apt-get update && \
#    apt-get install -y mysql-client && \
#    rm -rf /var/lib/apt/lists/*
ENTRYPOINT ["java", "-jar", "/app.jar"]