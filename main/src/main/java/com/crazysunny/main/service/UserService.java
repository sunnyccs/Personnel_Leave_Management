package com.crazysunny.main.service;

import com.crazysunny.main.entity.User;
import com.crazysunny.main.entity.UserHabitsEntity;
import com.crazysunny.main.mapper.UserHabitsMapper;
import com.crazysunny.main.mapper.UserMapper;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.MessageCode;
import com.crazysunny.main.message.MessageId;
import com.crazysunny.main.message.response.UserHabitsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserHabitsMapper habitsMapper;

    @Autowired
    private UserMapper userMapper;

    public UserHabitsResponse GetUserHabits(String  userName)
    {
        UserHabitsResponse response = new UserHabitsResponse();
        BaseMessage baseMessage = response.CreateMessage();
        // userMapper.getUserByName(MessageCodeuserID);
        User user = userMapper.getUserByName(userName);
        if (user == null) {
            baseMessage.setCode(MessageCode.Error);
            return response;
        }

        UserHabitsEntity habitsEntity = habitsMapper.getUserHabitsByUserID(user.getId());

        response.setUserHabits(habitsEntity.getFirstPage());
        return response;
    }
}
