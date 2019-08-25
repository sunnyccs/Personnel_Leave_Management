package com.crazysunny.main.Security;

import com.crazysunny.main.Tools.CommonUtils;
import com.crazysunny.main.entity.User;
import com.crazysunny.main.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);

        return info;
    }

    /*身份认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());

        String md5 = CommonUtils.GetMD5Pwd(userName,userPwd);

        User user = userMapper.selectByName(userName,md5);

        //String password = "123456";
        if (user == null) {
            throw new AccountException("用户名密码不正确");
        }

        return new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(userName + CommonUtils.PASSWORDHEX),getName());
    }




}

