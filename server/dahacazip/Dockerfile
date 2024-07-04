FROM amazoncorretto:19

LABEL maintainer="fayar"

WORKDIR /app
COPY target/Akilli-Fiyat-0.0.1-SNAPSHOT.jar Akilli-Fiyat.jar

VOLUME /tmp

ENV DB_URL=a
ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/Akilli-Fiyat.jar"]