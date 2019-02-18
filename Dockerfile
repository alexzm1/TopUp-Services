FROM maven:3.6.0-jdk-11-slim AS topup-build
VOLUME maven-repo:/root/.m2
WORKDIR /usr/src/topup-service
COPY . .
CMD mvn clean package

FROM openjdk:11.0.2-jre-slim
WORKDIR /usr/app/topup-service
COPY --from=topup-build /usr/src/topup-service/target/*.jar .
CMD java -jar /usr/app/topup-service/*.jar
