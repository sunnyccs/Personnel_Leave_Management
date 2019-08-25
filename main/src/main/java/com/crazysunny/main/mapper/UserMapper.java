package com.crazysunny.main.mapper;

import com.crazysunny.main.entity.User;

public interface UserMapper {

    int save(User user);

    int deleteById(int id);

    int createTable();

    User selectByName(String username,String password);
}
