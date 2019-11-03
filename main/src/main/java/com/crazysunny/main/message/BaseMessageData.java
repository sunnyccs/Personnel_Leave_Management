package com.crazysunny.main.message;

import com.alibaba.fastjson.JSONObject;

public class BaseMessageData {

    protected int messageId;

    public JSONObject GetMessageObject()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageId",messageId);
        return jsonObject;
    }

    public String GetMessageJson()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageId",messageId);
        return jsonObject.toJSONString();
    }
}
