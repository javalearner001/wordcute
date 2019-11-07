package com.sun.wordcute.controller;

import com.sun.wordcute.entity.common.BaseResult;
import com.sun.wordcute.entity.common.ErrorStatusEnum;
import com.sun.wordcute.entity.dto.WordBaseParam;
import com.sun.wordcute.entity.pojo.WordBase;
import com.sun.wordcute.service.WordBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 11:12
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/wordcute/wordbase")
public class WordBaseController {
    private static final Logger logger = LoggerFactory.getLogger(WordBaseController.class);

    @Autowired
    private WordBaseService wordBaseService;

    @GetMapping("/listWordBaseEasy")
    public BaseResult listWordBaseEasy(@RequestParam(value = "tag",required = true) Integer tag,@RequestParam(value = "pageSize",required = true) Integer pageSize,
                                       @RequestParam(value = "pageNum",required = true) Integer pageNum){
        logger.info("查询CET4-EASY 单词入参=====START=====,tag={}",tag);
        BaseResult result = new BaseResult();
        try {
            result = wordBaseService.listWordBaseByEasy(pageSize,pageNum);
        }catch (Exception e){
            logger.error("查询CET4-EASY 单词异常=====ERROR=====",e);
            result.setErrorCode(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getStatus());
            result.setMessage(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getDescription());
            return result;
        }
        return result;
    }

    @PostMapping("/postWordBaseEasy")
    public BaseResult listWordBaseEasy(@RequestBody WordBaseParam wordBaseParam){
        logger.info("查询CET4-EASY 单词入参=====START=====,tag={}",wordBaseParam);
        BaseResult result = new BaseResult();
        try {
            result = wordBaseService.listWordBaseByEasy(wordBaseParam.getPageSize(),wordBaseParam.getPageNum());
        }catch (Exception e){
            logger.error("查询CET4-EASY 单词异常=====ERROR=====",e);
            result.setErrorCode(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getStatus());
            result.setMessage(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getDescription());
            return result;
        }
        return result;
    }



}
