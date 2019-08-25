package com.crazysunny.main.message;

import com.alibaba.fastjson.JSONObject;

public class BaseMessageData {

    private int messageId;

    public String GetMessageJson()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageId",messageId);
        return jsonObject.toJSONString();
    }
}
