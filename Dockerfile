FROM openjdk:13
EXPOSE 5000

COPY build/libs/*.jar .
CMD java -jar *.jar

