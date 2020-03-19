# redisTemplate

使用redisTemplate的方式使用redis缓存
    
    1. 使用docker容器启动并运行redis
    docker run -p 6379:6379 -d redis:latest redis-server
    2. 连接docker容器中的redis服务时，需要知道redis对外暴露的ip
    可使用 docker inspect NAMES 查看对应服务的IPAddress
    3. 连接docker中启动的服务
    docker exec -it NAMES redis-cli