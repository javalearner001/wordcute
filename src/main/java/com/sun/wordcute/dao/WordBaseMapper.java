package com.sun.wordcute.dao;

import com.sun.wordcute.entity.dto.WordBaseParam;
import com.sun.wordcute.entity.pojo.WordBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 11:04
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface WordBaseMapper {

    List<WordBase> listWordBaseByEasy(WordBaseParam baseParam);

    int insertIntoWordBase(List<WordBase> wordBaseList);
}
