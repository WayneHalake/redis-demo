package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.RedisEntity;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get")
    public String get(String id){
        return redisTemplate.opsForValue().get(id).toString();
    }

    @PostMapping("/set")
    public void set(@RequestBody RedisEntity entity){
        redisTemplate.opsForValue().set(entity.getId(), entity.getValue());
    }

    /**
     * 获取HASHSET中的值
     * @param id
     * @param field
     * @return
     */
    @GetMapping("/hget")
    public String hget(String id, String field){
        return redisTemplate.opsForHash().get(id, field).toString();
    }

    @PostMapping("/hset")
    public void hset(@RequestBody RedisEntity entity){
        redisTemplate.opsForHash().putAll(entity.getId(), entity.getHashMap());
    }

    /**
     * list操作
     * @param entity
     */
    @PostMapping("/lPush")
    public void lPush(@RequestBody RedisEntity entity){
        redisTemplate.opsForList().leftPushAll(entity.getId(), entity.getArrayList());
    }

    @GetMapping("/lPop")
    public String lPop(@RequestBody RedisEntity entity){
        return redisTemplate.opsForList().leftPop(entity.getId()).toString();
    }

    @GetMapping("/lRange")
    public List lRange(@RequestBody RedisEntity entity){
        return redisTemplate.opsForList().range(entity.getId(), entity.getStart(), entity.getEnd());
    }


    @PostMapping("/rPush")
    public void rPush(@RequestBody RedisEntity entity){
        redisTemplate.opsForList().rightPushAll(entity.getId(), entity.getArrayList());
    }

    @GetMapping("/rPop")
    public String rPop(@RequestBody RedisEntity entity){
        return redisTemplate.opsForList().rightPop(entity.getId()).toString();
    }

    /**
     * SET操作
     * @param entity
     */
    @PostMapping("/addSet")
    public void addSet(@RequestBody RedisEntity entity){
        redisTemplate.opsForSet().add(entity.getId(), entity.getHashSet());
    }

    @GetMapping("/popSet")
    public String popSet(@RequestBody RedisEntity entity){
        return redisTemplate.opsForSet().pop(entity.getId()).toString();
    }

    @GetMapping("/memberSet")
    public Set memberSet(@RequestBody RedisEntity entity){
        return redisTemplate.opsForSet().members(entity.getId());
    }

    @PostMapping("/addZSet")
    public void addZSet(@RequestBody RedisEntity entity){
        redisTemplate.opsForZSet().add(entity.getId(), entity.getHashSet());
    }

    @GetMapping("/popZSet")
    public String popZSet(@RequestBody RedisEntity entity){
        return redisTemplate.opsForZSet().remove(entity.getId()).toString();
    }

}
