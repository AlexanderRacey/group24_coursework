FROM openjdk:latest
COPY ./target/seMethods.jar /tmp
ADD tomcat/mysql-connector-java-8.0.11.jar /tmp/lib/
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods.jar"]