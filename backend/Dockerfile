FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package
EXPOSE 8080
ADD ./target/*.jar ./app.jar
CMD java -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.config.name=application-deploy
