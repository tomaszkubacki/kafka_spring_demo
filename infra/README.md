## terraform topic management

```shell
terraform apply -auto-approve
```

```shell
terraform destroy -auto-approve
```

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

```shell
 curl -X DELETE http://localhost:8085/subjects/message-topic-value
```
