FROM alpine:latest
RUN apk add openjdk8
RUN mkdir /usr/local/webservice
ADD target/webservice-greeting.jar /usr/local/webservice/webservice-greeting.jar
RUN chmod +x /usr/local/webservice/webservice-greeting.jar
EXPOSE 8080
CMD java -jar /usr/local/webservice/webservice-greeting.jar
