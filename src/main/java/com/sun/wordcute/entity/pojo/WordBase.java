package com.sun.wordcute.entity.pojo;

import lombok.Data;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 10:47
 * @Description:
 * @Version 1.0
 */
@Data
public class WordBase implements java.io.Serializable {
    private static final long serialVersionUID = 6292929870075158395L;

    /**
     * 主键id
     */
    private int id;

    /**
     * 单词
     */
    private String word;

    /**
     * 单词翻译
     */
    private String translation;

    /**
     * 单词音标
     */
    private String phonetic;

    /**
     * 单词级别
     */
    private int tags;
}
