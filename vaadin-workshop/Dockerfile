FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY ./ /app
RUN mvn install



FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=0 /app/target/vaadin-workshop-1.0-SNAPSHOT.jar /app
CMD ["java", "-jar", "vaadin-workshop-1.0-SNAPSHOT.jar"]