## terraform topic management

Terraform is universal tool to do resource management. 
Terraform has Kafka plugin to manage topics. 
[main.ft](main.tf) contains our topic management.

Before we start we need to initialize terraform  state by invoking:
```shell
terraform init
```

To create topics (after installing terraform tool) simply invoke from cli:

```shell
terraform apply -auto-approve
```

To remove all topics:

```shell
terraform destroy -auto-approve
```

## Schema management

Kafka Schema is another tool to manage Kafka topics schemas.
More about this you can read [here](https://docs.confluent.io/platform/current/schema-registry/index.html) 

### Show schema types

```shell
curl http://localhost:8085/schemas/types
```

### Show registered schemas

```shell
curl http://localhost:8085/schemas
```

### show subjects

```shell
 curl -X GET http://localhost:8085/subjects
```

### show schemas

```shell
 curl -X GET http://localhost:8085/schemas
```

### Delete particular subject

```shell
 curl -X DELETE http://localhost:8085/subjects/message-topic-value
```
