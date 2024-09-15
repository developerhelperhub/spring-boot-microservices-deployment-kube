FROM openjdk:22-jdk

#Set the working directory
RUN mkdir /app
WORKDIR /app

#Copy the built application from the first stage
COPY target/app.jar /app/app.jar

#Expose port which our spring boot application is running
EXPOSE 8080

#Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=dev"]