FROM openjdk:8-jdk-alpine
ADD target/ping-kafka-1.0-SNAPSHOT-jar-with-dependencies.jar ping-kafka.jar
ENTRYPOINT [ "sh", "-c", "java -jar ping-kafka.jar" ]