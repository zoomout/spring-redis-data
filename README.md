# Start Redis in Docker container
```
docker run --name my-redis -p 6379:6379 -d redis
```

# Start Spring boot web app
```
mvn spring-boot:run
```

# Use REST API to create, retrieve and delete an entity in Redis
```
curl -v -X POST 'localhost:8080/students' --header 'Content-Type: application/json' --data-raw '{"name": "Ivan","gender": "MALE","grade": 2}'
curl -v -X GET 'localhost:8080/students'
curl -v -X DELETE 'localhost:8080/students/cd803a06-a52c-4c43-ad22-f4bcc8f08af4'
```

# Delete Redis Docker container
```
docker rm -f my-redis
```