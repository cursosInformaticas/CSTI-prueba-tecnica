FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-03

COPY ./pom.xml /app
COPY ./msvc-03/.mvn ./.mvn
COPY ./msvc-03/mvnw .
COPY ./msvc-03/pom.xml .

RUN ./mvnw dependency:go-offline
COPY ./msvc-03/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/msvc-03/target/msvc-03-0.0.1-SNAPSHOT.jar .
EXPOSE 8083

CMD ["java", "-jar", "msvc-03-0.0.1-SNAPSHOT.jar"]