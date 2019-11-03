package com.crazysunny.main.mapper;

import com.crazysunny.main.entity.UserHabitsEntity;

public interface UserHabitsMapper {

    public UserHabitsEntity getUserHabitsByUserID(int userID);

    public int createTable();

    public int updateTable(UserHabitsEntity entity);

    public int insertTable(UserHabitsEntity entity);

}
