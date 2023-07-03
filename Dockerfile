FROM openjdk:17-oracle
COPY *.jar testapp.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","testapp.jar"]
