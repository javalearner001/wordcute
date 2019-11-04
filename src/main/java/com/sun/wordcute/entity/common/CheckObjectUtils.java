package com.sun.wordcute.entity.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 孙凯
 * @Date: 2019/9/18 17:23
 * @Description:
 * @Version 1.0
 */
public class CheckObjectUtils {
    private static final Logger logger = LoggerFactory.getLogger(CheckObjectUtils.class);

    /**
     * 校验对象属性均不能为空!
     *
     * @param obj
     * @return
     * @author DengYang
     */
    public static BaseResult checkObject(Object obj) {
        BaseResult result = new BaseResult();
        if (obj == null){
            result.setErrorCode("1");
            result.setMessage("参数不能为空!");
            return result;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (StringUtils.isEmpty(field.get(obj))) {
                    logger.error("==> " + field.getName() + "不能为空!");
                    result.setErrorCode("1");
                    result.setMessage(field.getName() + "不能为空!");
                    return result;
                }
            } catch (IllegalAccessException e) {
                result.setErrorCode("1");
                result.setMessage(field.getName() + "不能为空!");
                return result;
            }
        }
        return result;
    }

    /**
     * 指定字段名字,校验对象属性不能为空!
     *
     * @param obj
     * @return
     * @author DengYang
     */
    public static BaseResult checkObjectByFileldName(Object obj, String... checkColumnName) {
        BaseResult result = new BaseResult();
        if (obj == null){
            result.setErrorCode("2");
            result.setMessage("参数不能为空!");
            return result;
        }

        Map<String,Integer> checkColumnMap = new HashMap<>();
        for (String filter : checkColumnName) {
            checkColumnMap.put(filter,1);
        }

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (!checkColumnMap.containsKey(fieldName)){
                continue;
            }
            try {
                if (StringUtils.isEmpty(field.get(obj))) {
                    logger.info("==> " + field.getName() + "不能为空!");
                    result.setErrorCode("2");
                    result.setMessage(field.getName() + "不能为空!");
                    return result;
                }
            } catch (IllegalAccessException e) {
                result.setErrorCode("2");
                result.setMessage(field.getName() + "不能为空!");
                return result;
            }
        }
        return result;
    }

    /**
     * 过滤掉字段后,校验剩余对象属性不能为空!
     *
     * @param obj
     * @return
     * @author DengYang
     */
    public static BaseResult checkObjectWithFilter(Object obj, String... filterColumnName) {
        BaseResult result = new BaseResult();
        if (obj == null){
            result.setErrorCode("1");
            result.setMessage("参数不能为空!");
            return result;
        }
        Map<String,Integer> filterColumnMap = new HashMap<>();
        for (String filter : filterColumnName) {
            filterColumnMap.put(filter,1);
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (filterColumnMap.containsKey(fieldName)){
                continue;
            }
            try {
                if (StringUtils.isEmpty(field.get(obj))) {
                    logger.info("==> " + field.getName() + "不能为空!");
                    result.setErrorCode("1");
                    result.setMessage(field.getName() + "不能为空!");
                    return result;
                }
            } catch (IllegalAccessException e) {
                result.setErrorCode("1");
                result.setMessage(field.getName() + "不能为空!");
                return result;
            }

        }
        return result;
    }

}
