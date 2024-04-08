FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-02

COPY ./pom.xml /app
COPY ./msvc-02/.mvn ./.mvn
COPY ./msvc-02/mvnw .
COPY ./msvc-02/pom.xml .

RUN ./mvnw dependency:go-offline
COPY ./msvc-02/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/msvc-02/target/msvc-02-0.0.1-SNAPSHOT.jar .
EXPOSE 8082

CMD ["java", "-jar", "msvc-02-0.0.1-SNAPSHOT.jar"]