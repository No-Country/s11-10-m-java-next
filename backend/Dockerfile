FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install -P prod

FROM openjdk:17.0.1-jdk-slim
ENV SPRING_PROFILES_ACTIVE=prod
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080
CMD ["java", "-jar", "demo.jar"]

