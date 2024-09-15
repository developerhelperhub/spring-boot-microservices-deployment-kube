
# Build and Deploy micorservices Order Service "order-service" for Prod environment

## Build the maven
The native image building to run the production environment to functionality and stability of the application.
```shell
cd spring-boot-microservices/order-service

mvn -Pnative native:compile
```

## Build docker image and pushing docker hub
```shell
cd spring-boot-microservices/order-service

docker build -f deployment/prod/Dockerfile -t  developerhelperhub/mes-order-service:1.0.0.1 .
docker push developerhelperhub/mes-order-service:1.0.0.1
```

### Runing and testing application locally
```shell
docker run --name mes-order-service --rm -p 8082:8080 developerhelperhub/mes-order-service:1.0.0.1
```

Following curl commands we can use to test the APIs
```shell
curl --location 'http://localhost:8082/orders'
curl --location 'http://localhost:8082/actuator/health'
curl --location 'http://localhost:8082/actuator/health/readiness'
curl --location 'http://localhost:8082/actuator/health/liveness'
curl --location 'http://localhost:8082/actuator/health/startup'
curl --location 'http://localhost:8082/actuator/info'
```
Note: Postman collection available in the repository

### Push docker image to docker hub
```shell
docker push developerhelperhub/mes-order-service:1.0.0.1-SNAPSHOT
```