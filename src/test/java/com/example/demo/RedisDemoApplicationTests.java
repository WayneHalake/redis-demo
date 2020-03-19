package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

	@Autowired
	RedisTemplate redisTemplate;  //k- v 都是对象

	/**
	 * redis 常见
	 * String(字符串) List(列表) Set(集合) Hash(散列) ZSet(有序集合)
	 */

	@Test
	public void test1() {
		stringRedisTemplate.opsForValue().append("StringKey", "字符串数值");
		String value = stringRedisTemplate.opsForValue().get("StringKey");
		System.out.println(value);
	}

	@Test
	public void test2() {
//
//		Product product =  productMapper.getProductById(4L);
//		redisTemplate.opsForValue().set("produxtid4",product);
	}


	@Test
	void contextLoads() {
	}

}
