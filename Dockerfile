FROM amazoncorretto:20.0.1
WORKDIR /usr/src/card
VOLUME /tmp
EXPOSE 8080
COPY ./target/card-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java \
 -Djava.security.egd=file:/dev/./urandom \
 -Dspring.profiles.active=local \
 -Duser.timezone=Africa/Nairobi \
 -Dcustom.host=database-host \
 -jar app.jar
