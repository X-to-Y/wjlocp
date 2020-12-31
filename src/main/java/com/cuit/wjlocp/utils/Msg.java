package com.cuit.wjlocp.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 *
 * @author
 */
public class Msg implements Serializable {
    private String code;
    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> data = new HashMap<String, Object>();

    public static com.cuit.wjlocp.utils.Msg success() {
        com.cuit.wjlocp.utils.Msg result = new com.cuit.wjlocp.utils.Msg();
        result.setCode("200");
        result.setMsg("处理成功！");
        return result;
    }

    public static com.cuit.wjlocp.utils.Msg fail() {
        com.cuit.wjlocp.utils.Msg result = new com.cuit.wjlocp.utils.Msg();
        result.setCode("400");
        result.setMsg("处理失败！");
        return result;
    }

    public static com.cuit.wjlocp.utils.Msg notFound() {
        com.cuit.wjlocp.utils.Msg result = new com.cuit.wjlocp.utils.Msg();
        result.setCode("404");
        result.setMsg("网页未找到！");
        return result;
    }

    public static com.cuit.wjlocp.utils.Msg authFail() {
        com.cuit.wjlocp.utils.Msg result = new com.cuit.wjlocp.utils.Msg();
        result.setCode("403");
        result.setMsg("权限不足！");
        return result;
    }


    public com.cuit.wjlocp.utils.Msg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Msg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
