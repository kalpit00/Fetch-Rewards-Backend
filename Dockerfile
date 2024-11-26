# Use an OpenJDK base image to run the application
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/Fetch-Rewards-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
