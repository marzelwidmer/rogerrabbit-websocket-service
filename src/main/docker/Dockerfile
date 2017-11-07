FROM hypriot/rpi-java
VOLUME /tmp
ADD rogerrabbit-websocket-service.jar target/app.jar
RUN sh -c 'touch target/app.jar'
ENV JAVA_OPTS="-Dserver.address=0.0.0.0 -Dspring.profiles.active=local"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar target/app.jar" ]