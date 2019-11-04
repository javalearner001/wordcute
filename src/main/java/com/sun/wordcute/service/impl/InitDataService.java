package com.sun.wordcute.service.impl;

import com.sun.wordcute.dao.WordBaseMapper;
import com.sun.wordcute.entity.pojo.WordBase;
import com.sun.wordcute.service.InitService;
import com.sun.wordcute.util.ReadXMLFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 13:25
 * @Description:
 * @Version 1.0
 */
@Service
public class InitDataService implements InitService {
    private static final Logger logger = LoggerFactory.getLogger(InitDataService.class);

    @Autowired
    private WordBaseMapper wordBaseMapper;

    @Override
    public void initData() {
        try {
            List<WordBase> wordBases = ReadXMLFile.initData();
            wordBaseMapper.insertIntoWordBase(wordBases);
        }catch (Exception e){
            logger.error("初始化数据异常=====ERROR=====",e);
        }
    }

}
