package com.sun.wordcute.entity.common;

import lombok.Data;

/**
 * @Author: 孙凯
 * @Date: 2019/4/25 14:15
 * @Version 1.0
 */
@Data
public class BaseResult<T> implements java.io.Serializable {
    private static final long serialVersionUID = 1712975487188389338L;

    private String errorCode;
    private String message;
    private T data;

    public BaseResult(){
        this.errorCode = "0";
        this.message = "SUCCESS";
    }
}
