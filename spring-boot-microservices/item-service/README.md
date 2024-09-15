```shell
docker build -f DockerfileDev -t  item-service .
```

```shell
docker build -f DockerfileProd -t  item-service .
```

```shell
docker run --name item-service -d -p 5001:8080 item-service
curl http://localhost:5001/items
```

```shell
docker logs -f item-service
```

```shell
sudo lsof -i -P | grep 5001
```