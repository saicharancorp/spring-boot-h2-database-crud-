
## Run Spring Boot application
```
mvn spring-boot:run
```
https://github.com/bezkoder/spring-boot-h2-database-crud

curl --location --request POST 'http://localhost:8080/api/tutorials' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '{
	"title": "test",
	"description": "test",
	"published": true
}'

Basic Auth : username , password
