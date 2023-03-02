FROM openjdk:13
EXPOSE 8080

COPY build/libs/*.jar .
CMD java -jar *.jar

