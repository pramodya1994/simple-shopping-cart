FROM maven:3.5.4-jdk-8-alpine as maven

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn dependency:go-offline -B

RUN mvn package

FROM openjdk:8u171-jre-alpine

WORKDIR /workdir

COPY --from=maven target/shopping-cart-1.0-SNAPSHOT-shaded.jar ./workdir/shopping-cart.jar

CMD ["java", "-jar", "./workdir/shopping-cart.jar"]