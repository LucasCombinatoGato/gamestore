## Estágio de compilação
## Uma imagem de linux para compilar o projeto
FROM ubunto:latest AS build

## Instalar o JAVA 21
RUN apt-get update
RUN apt-get install -y openjdk-21-jdk

## Instalar o maven
RUN apt-get install -y maven

## COPY do projeto para o container
COPY . .

## Compilar o projeto com o maven

RUN mvn clean install -DskipTests

## Execução do Projeto
FROM eclipse-temurin:21-jdk-jammy

# Expor a porta 8080
EXPOSE 8080

## Copiar o arquivo JAR da compilação para o container de execução
COPY --from=buld /target/GAMESTORE-0.0.1-snapshot.JAR APP.JAR

## Definir o comando de inicialização do container
ENTRYPOINT ["java", "-jar", "app.jar"]