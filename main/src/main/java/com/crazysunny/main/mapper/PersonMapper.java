package com.crazysunny.main.mapper;

import com.crazysunny.main.entity.PersonEntity;

import java.util.List;
import java.util.Map;

public interface PersonMapper {

    int save(PersonEntity personEntity);

    int deleteById(int id);

    int createTable();

    List<PersonEntity> selectByMutilParams(Map<String,Object> map);

    int getPersonCount(Map<String,Object> map);

    PersonEntity getPersonInfoByID(int personID);

    PersonEntity getPersonInfoByName(String personName);
}
