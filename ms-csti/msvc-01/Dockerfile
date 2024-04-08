FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-01

COPY ./pom.xml /app
COPY ./msvc-01/.mvn ./.mvn
COPY ./msvc-01/mvnw .
COPY ./msvc-01/pom.xml .

RUN ./mvnw dependency:go-offline
COPY ./msvc-01/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/msvc-01/target/msvc-01-0.0.1-SNAPSHOT.jar .
EXPOSE 8081

CMD ["java", "-jar", "msvc-01-0.0.1-SNAPSHOT.jar"]