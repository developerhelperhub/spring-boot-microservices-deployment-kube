```shell
docker build -f DockerfileDev -t  developerhelperhub/mes-item-service .
```

```shell
docker build -f DockerfileProd -t  developerhelperhub/mes-item-service .
```

```shell
docker run --name item-service -d -p 5001:8080 developerhelperhub/mes-item-service
curl http://localhost:5001/items
```

```shell
docker logs -f item-service
```

```shell
sudo lsof -i -P | grep 5001
```


kubectl -n microservices -f deployment-dev.yaml apply
kubectl -n microservices get all
kubectl -n microservices describe pod/mes-item-service-6cfd8b87bf-2f8pp
kubectl -n microservices -f service-dev.yaml apply
kubectl -n microservices get svc

kubectl -n microservices -f ingress-resource.yaml apply
curl http://mes.app.com/order-service/orders
