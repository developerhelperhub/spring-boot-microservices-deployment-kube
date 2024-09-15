
# Build and Deploy micorservices Order Service for Dev environment

## Build the maven
I am creating a Java JAR file to run the application in the development environment for quick deployment and testing the functionality. This approach is chosen to avoid the time-consuming process of building a native executable, which would delay testing and delivering the application to the QA team.
```shell
cd spring-boot-microservices/order-service

mvn clean install
```

### Build docker image and pushing docker hub
```shell
cd spring-boot-microservices/order-service

docker build -f deployment/dev/Dockerfile -t  developerhelperhub/mes-order-service:1.0.0.1-SNAPSHOT .
```

### Runing and testing application locally
```shell
docker run --name mes-order-service --rm -p 8082:8080 developerhelperhub/mes-order-service:1.0.0.1-SNAPSHOT
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


## Deploy the services in the Kubernetes

### Apply deployment and verify the pods
```shell
kubectl -n microservices -f deployment/dev/kube-deployment.yaml apply
kubectl -n microservices get pod -l app=mes-order-service
kubectl -n microservices describe pod/mes-order-service-64c86c5f56-c5cpd
kubectl -n microservices logs pod/mes-order-service-64c86c5f56-c5cpd
```

### Apply and verify the service
```shell
kubectl -n microservices -f deployment/dev/kube-service.yaml apply
kubectl -n microservices get svc
```

### Apply and verify the pod scalability configuration
```shell
kubectl -n microservices -f deployment/dev/kube-horizontal-pod-autoscaler.yaml apply
kubectl -n microservices get hpa

kubectl -n microservices -f deployment/dev/kube-pod-disruption-budget.yaml apply
kubectl -n microservices get pdb
```

### Apply ingress resource of microservices
```shell
kubectl -n microservices -f ../../ingress-resource.yaml apply
```

curl http://mes.app.com/order-service/orders


## References
* https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/