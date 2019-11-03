package com.crazysunny.main.User;

import com.crazysunny.main.Tools.DataTools;
import com.crazysunny.main.control.PersonListController;
import com.crazysunny.main.entity.PersonEntity;
import com.crazysunny.main.entity.UserHabitsEntity;
import com.crazysunny.main.mapper.PersonHolidyMapper;
import com.crazysunny.main.mapper.PersonMapper;
import com.crazysunny.main.mapper.UserHabitsMapper;
import com.crazysunny.main.service.PersonListService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private UserHabitsMapper userHabitsMapper;

    @Test
    public void CreateTable()
    {
        Assert.assertEquals(1,personMapper.createTable());
    }

    @Test
    public void  InsertTable()
    {
        for (int i = 0;i < 100;i ++)
        {
            PersonEntity personEntity = new PersonEntity();
            if (i % 2 == 0)
                personEntity.setGender("男");
            else
                personEntity.setGender("女");
            personEntity.setInstitute("test institue");
            if (i % 3 == 0)
                personEntity.setIscadre(0);
            else
                personEntity.setIscadre(1);
            personEntity.setJoinData(DataTools.GetCurrentTimeSpan());
            personEntity.setMarry(0);
            personEntity.setName("test" + i);
            personMapper.save(personEntity);
        }
//        PersonEntity personEntity = new PersonEntity();
//        personEntity.setGender("男");
//        personEntity.setInstitute("test institue");
//        personEntity.setIscadre(0);
//        personEntity.setJoinData(DataTools.GetCurrentTimeSpan());
//        personEntity.setMarry(0);
//        personEntity.setName("test");
        Assert.assertEquals(1,1);

    }

    @Test
    public void SelectTable()
    {
        Map<String ,Object> paramsObj = new HashMap<>();
        paramsObj.put("gender","男");
        paramsObj.put("limit",10);
        paramsObj.put("offset",10);
        List<PersonEntity> personEntity = personMapper.selectByMutilParams(paramsObj);
        //System.out.println(personEntity.size());
       // PersonEntity personEntity = personMapper.selectByMutilParams(paramsObj);
        Assert.assertEquals(1,personEntity.size());
    }

    @Test
    public void GetCount()
    {
        Map<String ,Object> paramsObj = new HashMap<>();
        paramsObj.put("gender","男");
        int count = personMapper.getPersonCount(paramsObj);
        System.out.println(count);
    }

    @Test
    public void CreateUserHabitsTable()
    {
        userHabitsMapper.createTable();
    }

    @Test
    public void InserUserHabitsData()
    {
        UserHabitsEntity entity = new UserHabitsEntity();
        entity.setUserID(3);
        entity.setFirstPage("name|gender|joinData|partLevel|institute|personLevel|iscadre");
        userHabitsMapper.insertTable(entity);
    }

    @Autowired
    PersonListService personListService;

    @Autowired
    PersonHolidyMapper personHolidyMapper;

    @Test
    public void SelectMutilTest()
    {
        Map<String,String> maps = new HashMap<>();
//        maps.put("name","test3");
//        maps.put("marry","0");
        maps.put("startJoinData","1567939615520");
        maps.put("endJoinData","1567939615600");

        personListService.getPersonListResponse(maps,"",0);
    }

    @Test
    public void CreatePersonHolidy()
    {
        personHolidyMapper.createTable();
    }
}


