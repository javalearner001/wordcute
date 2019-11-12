package com.sun.wordcute.service;

/**
 * @Author: 孙凯
 * @Date: 2019/11/12 11:49
 * @Description:
 * @Version 1.0
 */
public interface RedisService {

    void setStringRedis(String key,String value);

    String getStringRedis(String key);
}
