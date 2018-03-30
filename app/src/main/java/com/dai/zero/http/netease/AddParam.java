package com.dai.zero.http.netease;


import org.json.JSONException;
import org.json.JSONObject;

public class AddParam {
    public String url;
    public JSONObject paras;

    public AddParam() {
        this.paras = new JSONObject();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getParas() {
        return paras;
    }

    public void setParas(JSONObject paras) {
        this.paras = paras;
    }

    public AddParam addPara(String key, Object value) {
        try {
            this.paras.put(key, value.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public AddParam(String url, JSONObject paras) {
        this.url = url;
        this.paras = paras;
    }

    @Override
    public String toString() {
        return "UrlParamPair{" +
                "url='" + url + '\'' +
                ", paras=" + paras +
                '}';
    }
}
