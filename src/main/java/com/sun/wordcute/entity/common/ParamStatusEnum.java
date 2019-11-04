package com.sun.wordcute.entity.common;

/**
 * @author sunk
 * @date created in 20:57 2019/06/03
 */
public enum ParamStatusEnum {
    MISSING_PARAM("1", "缺少必选参数"),;


    private String status ;
    private String description ;

    private ParamStatusEnum(String status, String description ){
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
