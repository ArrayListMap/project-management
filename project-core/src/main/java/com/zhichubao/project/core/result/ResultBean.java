package com.zhichubao.project.core.result;

/**
 * Created by fuwb on 2017/1/4.
 */
public class ResultBean<T> {
    private int code;
    private String desc;
    private T data;
    private static ResultBean instance;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultBean<T> createdResultBean(int code, T t, String message) {
        if (instance == null) {
            instance = new ResultBean();
        }
        instance.setCode(code);
        instance.setData(t);
        instance.setDesc(message);
        return instance;
    }
}
