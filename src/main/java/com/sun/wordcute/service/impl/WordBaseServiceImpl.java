package com.sun.wordcute.service.impl;

import com.sun.wordcute.dao.WordBaseMapper;
import com.sun.wordcute.entity.common.BaseResult;
import com.sun.wordcute.entity.common.ErrorStatusEnum;
import com.sun.wordcute.entity.dto.WordBaseParam;
import com.sun.wordcute.entity.pojo.WordBase;
import com.sun.wordcute.service.WordBaseService;
import com.sun.wordcute.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 10:51
 * @Description:
 * @Version 1.0
 */
@Service
public class WordBaseServiceImpl implements WordBaseService {

    private static final Logger logger = LoggerFactory.getLogger(WordBaseServiceImpl.class);

    @Autowired
    private WordBaseMapper wordBaseMapper;


    @Override
    public BaseResult<List<WordBase>> listWordBaseByEasy(Integer pageSize,Integer pageNum) {
        logger.info("查询CET4-EASY 单词=====START=====");
        BaseResult<List<WordBase>> result = new BaseResult<>();
        try {
            PageBean pageBean = new PageBean();
            pageBean.setPageSize(pageSize);
            pageBean.setPageNumber(pageNum);

            WordBaseParam baseParam = new WordBaseParam();
            baseParam.setStartIndex(pageBean.getStartIndex());
            baseParam.setTag(10);
            baseParam.setPageSize(pageSize);
            List<WordBase> wordBases = wordBaseMapper.listWordBaseByEasy(baseParam);
            if (!ObjectUtils.isEmpty(wordBases)){
                result.setData(wordBases);
            }
        }catch (Exception e){
            logger.error("查询CET4-EASY 单词异常=====ERROR=====",e);
            result.setErrorCode(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getStatus());
            result.setMessage(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getDescription());
            return result;
        }
        logger.info("查询CET4-EASY 单词=====STOP=====");
        return result;
    }







    /*public BaseResult<List<WordBase>> listWordBaseByEasy() {
        logger.info("查询CET4-EASY 单词=====START=====");
        BaseResult<List<WordBase>> result = new BaseResult<>();
        try {

        }catch (Exception e){
            logger.error("查询CET4-EASY 单词异常=====ERROR=====",e);
            result.setErrorCode(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getStatus());
            result.setMessage(ErrorStatusEnum.SYSTEM_ERROR_STATUS.getDescription());
            return result;
        }
        logger.info("查询CET4-EASY 单词=====STOP=====");
        return result;
    }*/
}