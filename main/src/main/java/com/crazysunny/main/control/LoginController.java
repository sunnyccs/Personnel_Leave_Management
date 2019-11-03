package com.crazysunny.main.control;


import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.MessageCode;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value = "/loginPage")
    @ResponseBody
    public String defaultLogin() {
        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setCode(MessageCode.UnLogin);
        baseMessage.setMsg("未登录");
        return baseMessage.GetMessageJson();
    }


    @PostMapping(value = "/logintest/{username}")
    @ResponseBody
    public String LoginTest(@PathVariable String username, @RequestParam(value = "password") String password)
    {
        return "logintest";
    }

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login/{username}/{password}")
    @ResponseBody
    public String login(@PathVariable String username, @PathVariable String password) {
        BaseMessage baseMessage = new BaseMessage();

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("未知账户");
            //return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("密码不正确");
            //return "密码不正确";
        } catch (LockedAccountException lae) {
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("账户已锁定");
            //return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("用户名或密码错误次数过多");
            return baseMessage.GetMessageJson();
            //return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("用户名或密码不正确");
            return baseMessage.GetMessageJson();
            //return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            baseMessage.setCode(MessageCode.Success);
            baseMessage.setMsg("登录成功");
            //return "登录成功";
        } else {
            token.clear();
            baseMessage.setCode(MessageCode.Error);
            baseMessage.setMsg("登录失败");
            //return "登录失败";
        }
        return baseMessage.GetMessageJson();
    }
}
