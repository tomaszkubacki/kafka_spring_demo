# Kafka Spring Demo

Demo usage of Kafka in Spring application

### Run Kafka Cluster in docker (optional)
Run Kafka in docker

```shell
docker-compose up -d
```
or update kafka connection info in: [application.yml](src/main/resources/application.yml)

### Prepare Kafka topics

After cluster is up, prepare Kafka topics. 
From the project root do:
```shell
cd infra
terraform init
terraform apply 
```
see [infra/README.md](infra/README.md) for details 

### How to run
Run in the terminal:
```shell
./gradlew bootRun
```
open swagger UI at [openapi link](http://localhost:9988/swagger-ui/index.html)
