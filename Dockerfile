FROM alpine:latest
RUN apk add openjdk8
RUN mkdir /usr/local/webservice
ADD target/rest-service-0.0.1-SNAPSHOT.jar /usr/local/webservice/spring-webservice.jar
RUN chmod +x /usr/local/webservice/spring-webservice.jar
EXPOSE 8080
CMD java -jar /usr/local/webservice/spring-webservice.jar
