terraform {
  required_providers {
    kafka = {
      source  = "Mongey/kafka"
      version = "0.5.4"
    }
  }
}

provider "kafka" {
  bootstrap_servers = ["localhost:29092"]
  #  ca_cert           = file("../secrets/ca.crt")
  #  client_cert       = file("../secrets/terraform-cert.pem")
  #  client_key        = file("../secrets/terraform.pem")
  tls_enabled       = false
}


resource "kafka_topic" "userAdded" {
  name               = "user.fct.userAdded"
  replication_factor = 1
  partitions         = 1
  config             = {
    "cleanup.policy" = "delete"
  }
}


resource "kafka_topic" "currency" {
  name               = "settings.cdc.currency"
  replication_factor = 1
  partitions         = 1
  config             = {
    "cleanup.policy" = "compact"
  }
}