# centra-server
Centra services

## How to run

### Requirements
* MongoDB 4.x
* Gradle 6.7

### Running the app
* Ensure the applications.properties file has to correct fallback parameters for your database connection.
* ./gradlew bootRun
* SwaggerUI available at http://localhost:8080/swagger-ui/ (if env var SWAGGER_ENABLED=true)
* The application will be available at http://localhost:8080. For the first time installation, the license key is not required. 
