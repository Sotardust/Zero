package com.dai.zero.http.netease;


import java.util.HashMap;

public class FillParam {
    private HashMap<String, Object> param;

    public FillParam() {
        param = new HashMap<>();
    }

    public FillParam addParam(String key, Object value) {
        param.put(key, value.toString());
        return this;
    }

    @Override
    public String toString() {
        return param.toString();
    }
}
