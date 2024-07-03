# Use an official OpenJDK runtime as a parent image
FROM openjdk:20-jdk-slim

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the current directory contents into the container at /app
COPY . /app

# Set the working directory to /app
WORKDIR /app

# Grant execution permissions to the mvnw script
RUN chmod +x ./mvnw

# Run the application
CMD ["./mvnw", "spring-boot:run"]
