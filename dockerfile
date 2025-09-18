# ---------- Stage 1: Build ----------
FROM gradle:7.6.6-jdk17 AS builder
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle clean build -x test --no-daemon

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy only the built JAR from the builder stage
COPY --from=builder /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
