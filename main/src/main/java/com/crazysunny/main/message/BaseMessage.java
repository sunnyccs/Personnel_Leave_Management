package com.crazysunny.main.message;

import com.alibaba.fastjson.JSONObject;

public class BaseMessage {
    protected int code;

    protected BaseMessageData data;

    protected String msg;

    public BaseMessage() {
    }

    public BaseMessage(BaseMessageData data) {
        this.data = data;
    }

    public BaseMessage(int code, BaseMessageData data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BaseMessageData getData() {
        return data;
    }

    public void setData(BaseMessageData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String GetMessageJson()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        if (data != null)
            jsonObject.put("data",data.GetMessageJson());
        else
            jsonObject.put("data",null);
        jsonObject.put("msg",msg);
        return jsonObject.toJSONString();
    }
}
