FROM openjdk:17-oracle

ARG JAR_FILE=target/meuusado-searcher-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]

EXPOSE 9002
#EXPOSE 9300-9399