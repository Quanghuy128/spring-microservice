#Build Application
FROM eclipse-temurin:11-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install


#Run Application
FROM openjdk:latest
WORKDIR /app
COPY --from=build target/*.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]