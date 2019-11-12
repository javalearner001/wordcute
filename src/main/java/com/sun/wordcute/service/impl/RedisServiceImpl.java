package com.sun.wordcute.service.impl;

import com.sun.wordcute.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: 孙凯
 * @Date: 2019/11/12 13:58
 * @Description:
 * @Version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setStringRedis(String key,String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    @Override
    public String getStringRedis(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
