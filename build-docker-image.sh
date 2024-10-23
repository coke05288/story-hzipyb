#!/bin/bash

docker build -t nemomong/eureka-service:latest -f eureka-service/Dockerfile .
docker build -t nemomong/gateway-service:latest -f gateway-service/Dockerfile .
docker build -t nemomong/blog-service:latest -f blog-service/Dockerfile .
docker build -t nemomong/blog-service:v1 -f blog-service/Dockerfile .

docker push nemomong/eureka-service:latest
docker push nemomong/gateway-service:latest
docker push nemomong/blog-service:latest
docker push nemomong/blog-service:v1