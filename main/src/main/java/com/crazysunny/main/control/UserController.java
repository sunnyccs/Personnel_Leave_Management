package com.crazysunny.main.control;

import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.MessageCode;
import com.crazysunny.main.message.response.UserHabitsResponse;
import com.crazysunny.main.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getHabtis")
    @ResponseBody
    public String GetUserHabits()
    {
        Subject subject = SecurityUtils.getSubject();
        Object prinicipal = subject.getPrincipal();
        if (prinicipal == null)
        {
            BaseMessage baseMessage = new BaseMessage();
            baseMessage.setCode(MessageCode.Error);
            return  baseMessage.GetMessageJson();
        }

        UserHabitsResponse response = userService.GetUserHabits((String)prinicipal);
        return response.GetMessageJson();
    }
}
