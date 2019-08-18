package com.crazysunny.main.User;

import com.crazysunny.main.Tools.DataTools;
import com.crazysunny.main.entity.User;
import com.crazysunny.main.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void Save()
    {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setLimits(0);
        user.setCreateTime(DataTools.GetCurrentTimeSpan());
        Assert.assertEquals(1,userMapper.save(user));
    }

    @Test
    public void CreateTable()
    {

        Assert.assertEquals(1,userMapper.createTable());
    }
}
