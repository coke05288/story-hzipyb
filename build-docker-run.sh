docker run -d --name eureka-service --network hzipyb -p 8000:8000 nemomong/eureka-service:latest
docker run -d --name gateway-service --network hzipyb -p 9000:8080 nemomong/gateway-service:latest
docker run -d --name blog-service --network hzipyb -p 8081:8080 nemomong/blog-service:latest