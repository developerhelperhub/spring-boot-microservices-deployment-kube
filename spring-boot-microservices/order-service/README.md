```shell
mvn clean install
docker build -f DockerfileDev -t  order-service .
```

```shell
 mvn -Pnative native:compile
docker build -f DockerfileProd -t  order-service .
```

```shell
docker run --name order-service -d -p 5002:8080 order-service
curl http://localhost:5002/orders
```

```shell
docker logs -f order-service
```

```shell
docker stop  order-service
docker rm  order-service
```

```shell
lsof -i -P | grep 8080
```