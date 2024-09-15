## Setup local environment
I use Docker containers to set up work environments for multiple applications([Setup Environment](https://dev.to/binoy_59380e698d318/setup-linux-box-on-local-with-docker-container-3k8)). This approach ensures fully isolated and maintainable environments for application development, allowing us to easily start and terminate these environments. Below is the Docker command to create the environment.
```shell
  docker run -it --name test-envornment-box -v ${HOME}:/root/ -v ${PWD}:/work -w /work --net host developerhelperhub/kub-terr-work-env-box sh
```

## Setup resources on Kubernetes 
I have created all the Terraform scripts, which are available in the GitHub repository. You can download and set up resources on a Kubernetes cluster, which runs locally in a Docker container. Following resources installed

**Set up the Kubernetes cluster** in a Docker container using Kind, naming the cluster “test-cluster-control-plane” This cluster supports ingress and exposes ports 80 and 443 to allow access to services from outside the cluster. Following resources also created along with this cluster creation


- Install Nginx ingress controller on Kubernetes cluster to manage the external access to services in a Kubernetes cluster. It acts as an entry point for your Kubernetes applications, routing external HTTP and HTTPS traffic to the appropriate services within the cluster.
- Create a namespace which called “microservices”
- Install Prometheus and Grafana to monitor the resources and services


**Clone the repository** onto your local Linux machine to get started.
```shell
git clone https://github.com/developerhelperhub/spring-boot-microservices-deployment-kube.git
cd terraform
```

Cluster create terraform script available under terraform folder
```shell
terraform init #Install the required providers to set up the necessary resources.
terraform plan -var="kind_cluster_name=microservices-development-cluster" #Verify the resources that will be installed on the system.
terraform apply -var="kind_cluster_name=microservices-development-cluster" #Install resources on the system
```
Following command verify the cluster and respective services
```shell
#Verifying the cluster and node
kubectl cluster-info
kubectl get nodes -o wide

#Verifying the ingress controll resources
kubectl get -n ingress-nginx pod

#Verifying the namespace
kubectl get namespace
```

Loging Grafana "http://grafana.devops.com" and it username and password are "admin" and "MyPassword1222@"
