# restaurant-catalog

docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=restaurantcatalog -p 5432:5432 postgres:13

mvn clean package

java -jar api/target/api-1.0-SNAPSHOT.jar
