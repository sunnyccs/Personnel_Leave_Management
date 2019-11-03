package com.crazysunny.main.message.response;


import com.alibaba.fastjson.JSONObject;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.BaseMessageData;
import com.crazysunny.main.message.MessageId;

public class UserHabitsResponse extends BaseMessageData {

    private String userHabits = null;

    public UserHabitsResponse()
    {
        messageId = MessageId.UserHabits;
    }

    public BaseMessage CreateMessage()
    {
        BaseMessage message = new BaseMessage(this);
        return message;
    }

    public String GetMessageJson()
    {
        JSONObject jsonObject = GetMessageObject();
        jsonObject.put("body",userHabits);
        return jsonObject.toJSONString();
    }

    public String getUserHabits() {
        return userHabits;
    }

    public void setUserHabits(String userHabits) {
        this.userHabits = userHabits;
    }
}
