

cd spring-boot-microservices/order-service

kubectl -n microservices -f deployment-dev.yaml apply
kubectl -n microservices get all
kubectl -n microservices describe pod/mes-order-service-7bb77755d8-8z9qx 
kubectl -n microservices -f service-dev.yaml apply
kubectl -n microservices get svc

kubectl -n microservices -f ingress-resource.yaml apply
curl http://mes.app.com/order-service/orders

kubectl delete namespace microservices
kubectl create namespace microservices

