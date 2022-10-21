FROM openjdk:17-jdk-alpine
EXPOSE 5000
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/dev.conductor.centra-1.0.0.jar
COPY ${JAR_FILE} dev.conductor.centra-1.0.0.jar
ENTRYPOINT ["java","-jar","/dev.conductor.centra-1.0.0.jar"]