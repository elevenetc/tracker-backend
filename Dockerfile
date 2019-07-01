FROM gradle:jdk8-alpine as buildstage

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:10-jre-slim
COPY --from=buildstage /home/gradle/src/build/libs/*.jar app.jar
WORKDIR .
EXPOSE 8080
CMD ["java","-jar","app.jar"]