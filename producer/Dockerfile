FROM eclipse-temurin:17-jdk-alpine

RUN apk --no-cache add curl
COPY target/dependency/BOOT-INF/lib /app/lib
COPY target/dependency/META-INF /app/META-INF
COPY target/dependency/BOOT-INF/classes /app

EXPOSE 8081
ENTRYPOINT ["java","-cp","app:app/lib/*","com.jaruiz.examples.observability.producer.ProducerSpringApplication"]
