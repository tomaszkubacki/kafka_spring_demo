# Kafka Spring Demo

Demo usage of Kafka in Spring application

### Run Kafka Cluster in docker (optional)
Run Kafka in docker

```shell
docker-compose up -d
```
or update kafka connection info in: [application.yml](src/main/resources/application.yml)
### How to run
Run in the terminal:
```shell
./gradlew bootRun
```

then open browser at [http://localhost:9988](http://localhost:9988)

or open swagger UI at [openapi link](http://localhost:9988/swagger-ui/index.html)
