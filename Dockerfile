FROM eclipse-temurin:21-jre
EXPOSE 8080

# Copy only the bootable JAR, not the -plain.jar
COPY build/libs/ph-ee-connector-channel-*.jar app.jar
CMD java -jar app.jar
