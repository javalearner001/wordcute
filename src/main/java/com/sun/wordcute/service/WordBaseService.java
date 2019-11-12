package com.sun.wordcute.service;

import com.sun.wordcute.entity.common.BaseResult;
import com.sun.wordcute.entity.pojo.WordBase;

import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 10:51
 * @Description:
 * @Version 1.0
 */
public interface WordBaseService {

    BaseResult<List<WordBase>> listWordBaseByEasy(Integer pageSize,Integer pageNum);

    BaseResult<List<WordBase>> redisListWordBaseByEasy(Integer pageSize,Integer pageNum);
}
