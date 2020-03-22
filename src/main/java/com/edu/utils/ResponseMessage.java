package com.edu.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {
    private String errorCode;
    private String errorMsg;
    private Map<String, Object> objectMap = new HashMap<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }

    public ResponseMessage addObject(String key, Object value){
        this.objectMap.put(key,value);
        return this;
    }

    public static ResponseMessage success(){
        ResponseMessage rm = new ResponseMessage();
        rm.errorCode="100";
        rm.errorMsg="处理成功";
        return rm;
    }

    public static ResponseMessage error(){
        ResponseMessage rm = new ResponseMessage();
        rm.errorCode="200";
        rm.errorMsg="处理失败";
        return rm;
    }
}
