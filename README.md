# restaurant-catalog

docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=restaurantcatalog -p 5432:5432 postgres

mvn clean package

java -jar api/target/api-1.0-SNAPSHOT.jar
