FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/my-app.jar /app/
EXPOSE 8080
CMD ["java", "-jar", "my-app.jar"]

