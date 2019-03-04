FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/airline-data-service-${version}.jar /airline-data-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /airline-data-service.jar
