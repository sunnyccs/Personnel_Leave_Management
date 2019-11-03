package com.crazysunny.main.message.response;

import com.alibaba.fastjson.JSONObject;
import com.crazysunny.main.entity.PersonEntity;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.BaseMessageData;
import com.crazysunny.main.message.MessageId;

import java.util.List;

public class PersonMainResponseData extends BaseMessageData {

    public PersonMainResponseData()
    {
       messageId = MessageId.PersonMain;
    }


    private List<PersonEntity> m_body;

    private int totalPage = 0;

    public BaseMessage CreateMessage()
    {
        BaseMessage message = new BaseMessage(this);
        return message;
    }

    public String GetMessageJson()
    {
        JSONObject jsonObject = GetMessageObject();
        jsonObject.put("body",m_body);
        return jsonObject.toJSONString();
    }


    public List<PersonEntity> getM_body() {
        return m_body;
    }

    public void setM_body(List<PersonEntity> m_body) {
        this.m_body = m_body;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
