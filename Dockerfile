FROM openjdk:13
EXPOSE 5000

COPY target/*.jar .
CMD java -jar *.jar

