# Step 1: Use an official Maven image with OpenJDK for building the app
FROM maven:3.8.4-openjdk-17-slim AS builder

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the entire project into the container
COPY . /app

# Step 4: Run Maven to build the project (this will create the JAR file in the target directory)
RUN mvn clean install -DskipTests

# Step 5: Use a smaller image for the runtime environment
FROM openjdk:17-jdk-slim

# Step 6: Set the working directory for the runtime container
WORKDIR /app

# Step 7: Copy the JAR file from the builder container to the runtime container
COPY --from=builder /app/target/*.jar app.jar

# Step 8: Expose the port your Spring Boot app will run on (usually 8080)
EXPOSE 8080

# Step 9: Define the command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
