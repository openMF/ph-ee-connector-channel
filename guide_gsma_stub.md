# How to add GSMA server side STUB api from OAS

### Step 1 - Import YAML

Import the [OAS YAML file](https://www.gsma.com/mobilefordevelopment/mobile-money/mobile-money-api/) in [swagger hub](https://app.swaggerhub.com/). Make sure there is no change made in the YAML file before importing it in swagger hub. After success import you will get a screen something like this.

<img width="633" alt="Screenshot 2022-09-28 at 12 54 33 PM" src="https://user-images.githubusercontent.com/31315800/192714147-7d2eb4f3-dcc5-4541-8626-bb29f392e6fc.png">


### Step 2 - Update YAML
Remove all the existing `allOf` property from OAS yaml. 
To achieve this task click on the editor section and use the find and replace feature(CTRL + F) to search for the existing `allOf` and replace it with empty string. 
To bring the replace box click on the `+ plus` icon as shown in below screen shot.

<img width="633" alt="Screenshot 2022-09-28 at 12 54 33 PM" src="https://user-images.githubusercontent.com/31315800/192715187-0a7f9d94-cd93-4926-95b6-e6141abfac55.png">

Make sure you do not messes with the YAML syntax while making the above changes. To check this make sure the bottom bar always says the `VALID`, as shown in below screen shot. If any-time while making changes it shows `ERROR` then you can expand the bottom section to see the exact error and resolve it.

<img width="633" alt="Screenshot 2022-09-28 at 12 54 33 PM" src="https://user-images.githubusercontent.com/31315800/192716486-bdb9bb05-52f4-448e-9033-68ce36dce732.png">

### Step 3 - Generate STUB Project
In the swagger hub page click on the `Export` :point_right: `Server Stub` :point_right: `Sring`. 
As shown in the below screen shot. 

<img width="633" alt="Screenshot 2022-09-28 at 12 54 33 PM" src="https://user-images.githubusercontent.com/31315800/192717931-513aed46-9711-44db-aedc-9e7a48b8de5a.png">

Be patient after clicking on the `spring` since it can take some time to download the project. Once the donwload is complete you will find a file named `spring-server-generated.zip` in your donwload folder. Exatract it andn open in you favourite IDE or Intellij Idea which support spring java project. Make sure the build is succesfull.

### Step 4 - Add Dependency In Channel Connector
Add below depedency in `channel-connector`, these dependency are borrowed from `spring-server-generated` project. 
Sync the `channel-connector` gradle project and make sure all dependency resolves and build is success.

```gradle
implementation 'io.springfox:springfox-swagger-ui:3.0.0'
implementation 'io.springfox:springfox-oas:3.0.0'
implementation 'com.github.joschi.jackson:jackson-datatype-threetenbp:2.6.4'
```

### Step 5 - Add APIs, Config and Model in Channel Connector

Copy the packages `api`, `configuration` and `model` from `spring-server-generated` project and paste it inside the `channel-connector` under the package `org.mifos.connector.gsmastub`. 
Also copy the `RFC3339DateFormat.java` file from `spring-server-generated` project and paste it in `channel-connector` under the package `org.mifos.connector.gsmastub`.

Make sure all the imports are resolved in all the files in newly pasted packages `api`, `configuration` and `model`.

### Step 6 - Update ChannelConnectorApplication.java

Add date configuration for webMvc as mentioned below.
```java
@Configuration
static class CustomDateConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }
}
```

Add deserializer for type `Instant.class`, `OffsetDateTime.class`, `LocalDate.class` and `ZonedDateTime.class` in the existing `objectMapper` initializer. Refer below code snippet.

```java
JavaTimeModule javaTimeModule = new JavaTimeModule();
javaTimeModule.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
javaTimeModule.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
javaTimeModule.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
javaTimeModule.addDeserializer(LocalDate.class, new CustomInstantDeserializer.LocalDateDeserializer());
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(javaTimeModule);
```

In case the deserializer is not generated for any of the type you can use below code snippet, as per your need.

```java
public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> { 
    @Override
    public LocalDate deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
        try {
            return LocalDate.parse(arg0.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        } catch (Exception e) {
        return LocalDate.parse(arg0.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }
}
```

### Step 7 - Remove Void auto generated Classes

Delete the below-mentioned models from `model` package and replace there uses with `String.class`.
`AvailableBalance.java` <br>
`CurrentBalance.java`<br>
`ReservedBalance.java`<br>
`UnclearedBalance.java`




### PS
* The endpoint are available on tomcat server port and not on the camel server port. So by default all the camle endpoints are accesible on `5000` port whereas WebMvc endpoints are accesible on `8080` port.
* To make sure endpoints are working fine, try running the below curl request.
    ```bash
    # for localhost
    curl --location --request GET 'http://localhost:8080/heartbeat' \
    --header 'Accept: application/json'
  
    # for SIT cluster
    curl --location --request GET 'https://channel-gsma.sandbox.fynarfin.io/heartbeat/' \
    --header 'Accept: application/json'
    ```
    
## Resources
:point_right: [OAS for GSMA latest version](https://www.gsma.com/mobilefordevelopment/mobile-money/mobile-money-api/)
:point_right: [Swagger Hub](https://app.swaggerhub.com/home)
