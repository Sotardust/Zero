package com.dai.zero.main.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public class ParamAnalysisUtil {

    public static HashMap<String, String> stringToHashMap(String s) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            hashMap.put("params", jsonObject.getString("params"));
            hashMap.put("encSecKey", jsonObject.getString("encSecKey"));
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return hashMap;
        }
    }
}
