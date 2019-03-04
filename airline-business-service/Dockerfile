FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/airline-business-service-${version}.jar /airline-business-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /airline-business-service.jar
