package com.sun.wordcute.entity.dto;

import lombok.Data;

/**
 * @Author: 孙凯
 * @Date: 2019/11/4 14:15
 * @Description:
 * @Version 1.0
 */
@Data
public class WordBaseParam implements java.io.Serializable {
    private static final long serialVersionUID = 6704089243422366725L;

    private Integer tag;

    private Integer startIndex;

    private Integer pageSize;

    private Integer pageNum;
}
