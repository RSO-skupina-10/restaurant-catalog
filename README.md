# restaurant-catalog

## How to start app (first option)
### run docker:
- `docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=restaurantcatalog -p 5432:5432 postgres:13`

### build and run:

- `mvn clean package`

- `java -jar api/target/api-1.0-SNAPSHOT.jar`

### now your app started


### to stop docker:
- `docker stop postgres-jdbc`

### to start docker again:
- `docker start postgres-jdbc`

### when app is running, try:
- http://localhost:8080/servlet
- http://localhost:8080/v1/restaurants

### Swagger UI:
- http://localhost:8080/api-specs/ui

### Swagger:
- http://localhost:8080/openapi
