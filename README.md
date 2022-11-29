# restaurant-catalog

## How to start app (first option)
### run docker:
- `docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=restaurantcatalog -p 5432:5432 postgres:13`

### build and run:

- `mvn clean package`

- `java -jar api/target/api-1.0-SNAPSHOT.jar`

### now your app started

## How to start app (second option)
- `docker build -t rso-restaurant-catalog .` (you can use multilayered Docker image `docker build -f ./Dockerfile_with_maven_build -t restaurant-catalog-multilayer .`)
- `docker network create rso`
- `docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=restaurantcatalog -p 5432:5432 --network rso postgres:13`
- `docker run -p 8080:8080 --network rso --name restaurant-catalog -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://postgres-jdbc:5432/restaurantcatalog rso-restaurant-catalog` (or `docker run -p 8080:8080 --network rso --name restaurant-catalog -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://postgres-jdbc:5432/restaurantcatalog rso-restaurant-multilayer`)


### to stop docker:
- `docker stop restaurant-catalog`
- `docker stop postgres-jdbc`

### to start docker again:
- `docker start postgres-jdbc`
- `docker start restaurant-catalog`

### when app is running, try:
- http://localhost:8080/servlet
- http://localhost:8080/v1/restaurants

### Swagger UI:
- http://localhost:8080/api-specs/ui

### Swagger:
- http://localhost:8080/openapi

## Docker Hub
- https://hub.docker.com/r/aljkor/restaurant-catalog

## Azure & Kubernetes
- `az login`
- `az account set --subscription xxxxxxxxxxxx`
- `az aks get-credentials --resource-group xxxxxx --name xxxx`
- `kubectl version`
- `kubectl get nodes`
- `kubectl create -f k8s/restaurant-catalog-deployment.yaml`
- `kubectl create secret generic pg-pass --from-literal=KUMULUZEE_DATASOURCES0_PASSWORD='xxxxxx'`
- `kubectl apply -f k8s/restaurant-catalog-deployment.yaml`
- `kubectl get services`
- `kubectl get deployments`
- `kubectl get pods`
- `kubectl logs restaurant-catalog-deployment-xxxxxxxxxx`
- try http://rsorestaurants-dns-cddf9c01.hcp.eastus.azmk8s.io/v1/restaurants
