package com.sun.wordcute.controller;

import com.sun.wordcute.entity.common.BaseResult;
import com.sun.wordcute.service.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 13:23
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/wordcute/init")
public class InitDataController {

    private static final Logger logger = LoggerFactory.getLogger(InitDataController.class);

    @Autowired
    private InitService initService;

    /*@GetMapping("/initData")
    public BaseResult initData(@RequestParam("start") Integer start){
        logger.info("初始化入参：start={}",start);
        if (start == 200){
            initService.initData();
        }
        return new BaseResult();
    }*/
}
