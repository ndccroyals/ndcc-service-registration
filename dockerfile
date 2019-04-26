
FROM openjdk:8
ENV APP_HOME=C:/janu/devlopment/devops/ndcc-service-registration/
RUN mkdir registration
ADD build/libs/*.jar /registration/registration.jar
ENTRYPOINT ["java", "-jar", "/registration/registration.jar"]