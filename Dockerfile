FROM java:8

MAINTAINER rmeloca@gmail.com

WORKDIR /app

ADD ./target/Gateway.jar /app/

EXPOSE 8080

CMD ["java", "-Xmx200m", "-jar", "/app/Gateway.jar"]