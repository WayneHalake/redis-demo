package com.example.demo.service.impl;

import com.example.demo.entity.TManagerUser;
import com.example.demo.mapper.TManagerUserMapper;
import com.example.demo.service.ITManagerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wayne
 * @since 2020-03-18
 */
@Service
public class TManagerUserServiceImpl extends ServiceImpl<TManagerUserMapper, TManagerUser> implements ITManagerUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public TManagerUser getManagerUserById(String id) {
        TManagerUser result = (TManagerUser) redisTemplate.opsForValue().get(id);
        if(result == null){
            result = getById(id);
            redisTemplate.opsForValue().set(id, result);
        }
        return result;
    }
}
