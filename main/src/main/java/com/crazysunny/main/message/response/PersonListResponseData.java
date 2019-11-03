package com.crazysunny.main.message.response;

import com.alibaba.fastjson.JSONObject;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.BaseMessageData;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class PersonListResponseData extends BaseMessageData {

    private List<String> m_header;

    private List<Object[]> m_body;

    //private List<Map<String,Object>> m_body;

    public String GetMessageJson()
    {
        JSONObject jsonObject = GetMessageObject();
        jsonObject.put("header",m_header);
        jsonObject.put("body",m_body);
        return jsonObject.toJSONString();
    }

    public BaseMessage CreateMessage()
    {
        BaseMessage message = new BaseMessage(this);
        return message;
    }

    public List<String> getM_header() {
        return m_header;
    }

    public void setM_header(List<String> m_header) {
        this.m_header = m_header;
    }

//    public List<Map<String, Object>> getM_body() {
//        return m_body;
//    }
//
//    public void setM_body(List<Map<String, Object>> m_body) {
//        this.m_body = m_body;
//    }


    public List<Object[]> getM_body() {
        return m_body;
    }

    public void setM_body(List<Object[]> m_body) {
        this.m_body = m_body;
    }
}
