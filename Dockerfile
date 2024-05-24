FROM openjdk:17

RUN addgroup --system <group>
RUN adduser --system <user> --ingroup <group>
USER <user>:<group>

EXPOSE 8080

COPY build/libs/*.jar ./
CMD java -jar *.jar
