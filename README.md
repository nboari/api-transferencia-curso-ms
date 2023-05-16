# api-transferencia-curso-ms

Para levantar el elk, usamos este repo: https://github.com/lemoncode21/docker-loging-elk/blob/master/docker-compose.yml

Y como ejemplo de codigo para conectarnos con logstash, tomamos de base este: https://github.com/lemoncode21/springboot-logging-elk

Para levantar el redis: usar el docker-compose-redis.yml

Para crear el topico, dentro del contenedor:
/opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server SERVER-IP:9092 --replication-factor 1 --partitions 1 --topic clienteTopic



