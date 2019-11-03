package com.crazysunny.main.message.response;

import com.alibaba.fastjson.JSONObject;
import com.crazysunny.main.entity.PersonEntity;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.BaseMessageData;
import com.crazysunny.main.message.MessageId;

public class PersonDetailInfoResponseData extends BaseMessageData {

    private PersonEntity personEntity = null;

    public PersonDetailInfoResponseData()
    {
        messageId = MessageId.PersonDetailInfo;
    }

    public BaseMessage CreateMessage()
    {
        BaseMessage baseMessage = new BaseMessage(this);
        return baseMessage;
    }

    public String GetMessageJson()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("person",personEntity);
        return jsonObject.toJSONString();
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
