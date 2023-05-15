# api-transferencia-curso-ms

Para levantar el elk, usamos este repo: https://github.com/lemoncode21/docker-loging-elk/blob/master/docker-compose.yml

Y como ejemplo de codigo para conectarnos con logstash, tomamos de base este: https://github.com/lemoncode21/springboot-logging-elk

Para levantar el redis:

´´´

version: '2'

services:
  redis:
    image: 'bitnami/redis:latest'    
    environment:
      - REDIS_PORT_NUMBER=7000
      - ALLOW_EMPTY_PASSWORD=yes        
    ports:
      - '7000:7000'


´´´
