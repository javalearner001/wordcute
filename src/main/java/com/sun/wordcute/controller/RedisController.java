package com.sun.wordcute.controller;

import com.sun.wordcute.entity.common.BaseResult;
import com.sun.wordcute.service.RedisService;
import com.sun.wordcute.service.WordBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孙凯
 * @Date: 2019/11/12 14:01
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/wordcute/redis")
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(InitDataController.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private WordBaseService wordBaseService;

    @GetMapping("/set")
    public void set(@RequestParam(value = "key",required = true) String key,
                                       @RequestParam(value = "value",required = true) String value){
        logger.info("redis 的====SET====方法 String类型，入参：key={},value={}",key,value);
        //redisService.setStringRedis(key,value);
        wordBaseService.redisListWordBaseByEasy(20,1);
    }

    @GetMapping("/get")
    public String get(@RequestParam(value = "key",required = true) String key){
        logger.info("redis 的====GET====方法 String类型，入参：key={}",key);
        return redisService.getStringRedis(key);
    }


}
