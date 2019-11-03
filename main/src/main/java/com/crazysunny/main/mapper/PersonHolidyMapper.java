package com.crazysunny.main.mapper;

import com.crazysunny.main.entity.PersonHolidyEntity;

import java.util.List;
import java.util.Map;

public interface PersonHolidyMapper {

    int createTable();

    PersonHolidyEntity getHolidyByID();

    List<PersonHolidyEntity> getHolidybyConditions(Map<String,Object> conditions);

    int insertHolidy(PersonHolidyEntity personHolidyEntity);
}
