#FROM java:8
#VOLUME /tmp
#ADD docker-spring-app.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]

FROM hypriot/rpi-java
VOLUME /tmp
ADD rogerrabbit-websocket-service.jar target/app.jar
RUN sh -c 'touch target/app.jar'
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=local -Djava.security.egd=file:/dev/./urandom -jar target/app.jar" ]
#ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]


#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/gs-spring-boot-docker-0.1.0.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar