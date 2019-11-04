package com.sun.wordcute.entity.common;

/**
 * @Author: 孙凯
 * @Date: 2019/8/21 11:36
 * @Description:
 * @Version 1.0
 */
public enum ErrorStatusEnum {
    DATA_ERROR_STATUS("1", "接口数据异常"),
    SYSTEM_ERROR_STATUS("2","系统出现异常")
    ;


    private String status ;
    private String description ;

    private ErrorStatusEnum(String status, String description ){
        this.status = status ;
        this.description = description ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
