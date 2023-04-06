FROM amazoncorretto:17.0.6-al2023
VOLUME /tmp
EXPOSE 8080 5432
ARG JAR_FILE=target/dpd-demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
