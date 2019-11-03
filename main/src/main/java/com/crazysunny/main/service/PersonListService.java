package com.crazysunny.main.service;

import com.crazysunny.main.Tools.PersonUtils;
import com.crazysunny.main.entity.PersonEntity;
import com.crazysunny.main.entity.PersonHolidyEntity;
import com.crazysunny.main.entity.User;
import com.crazysunny.main.entity.UserHabitsEntity;
import com.crazysunny.main.mapper.PersonHolidyMapper;
import com.crazysunny.main.mapper.PersonMapper;
import com.crazysunny.main.mapper.UserHabitsMapper;
import com.crazysunny.main.mapper.UserMapper;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.MessageCode;
import com.crazysunny.main.message.response.PersonListResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.util.*;

@Service
public class PersonListService {

    private static final int page_count = 10;
    private static final String offsetStr = "offset";
    private static final String limitStr = "limit";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private UserHabitsMapper userHabitsMapper;

    @Autowired
    private PersonHolidyMapper personHolidyMapper;


    public String getPersonListResponse(Map<String,String> conditionDic, String personName, int pageIndex)
    {
        PersonListResponseData personListResponseData = new PersonListResponseData();
        BaseMessage baseMessage = personListResponseData.CreateMessage();

        User user = userMapper.getUserByName(personName);
        if (user == null) {
            baseMessage.setCode(MessageCode.Error);
            return baseMessage.GetMessageJson();
        }

        //用户首页行为习惯
        UserHabitsEntity habitsEntity = userHabitsMapper.getUserHabitsByUserID(user.getId());
        String userHabits = habitsEntity.getFirstPage();
        String[] header = userHabits.split("\\|");

        Map<String ,Object> personConditionDic = new HashMap<>();

        Map<String,Object> holidyConditionDic = new HashMap<>();

        int offset = page_count * pageIndex;
        personConditionDic.put(limitStr,page_count);
        personConditionDic.put(offsetStr,offset);

        for (String key: conditionDic.keySet()) {
            if (IsPersonTableContain(key))
                personConditionDic.put(key,conditionDic.get(key));
            else
                holidyConditionDic.put(key,conditionDic.get(key));
        }

        holidyConditionDic.put("personID",0);

        List<PersonEntity> personEntityArray = personMapper.selectByMutilParams(personConditionDic);

        List<String> resHeader = new ArrayList<>();

        //List<Map<String,Object>> resbody = new ArrayList<>();

        Map<String,String> allHeader = PersonUtils.getPersonListHeader();
        for (int headerIndex = 0;headerIndex < header.length;headerIndex ++) {
            resHeader.add(allHeader.get(header[headerIndex]));
        }

        List<Object[]> resBodyArray = new ArrayList<>(personEntityArray.size());
        for (int i=0;i < personEntityArray.size();i ++){

            PersonEntity personEntity = personEntityArray.get(i);

            holidyConditionDic.replace("personID",personEntity.getId());

            List<PersonHolidyEntity> holidyEntities = personHolidyMapper.getHolidybyConditions(holidyConditionDic);
            PersonHolidyEntity holidyEntity = null;
            if (holidyEntities.size() > 0)
            {
                holidyEntity = holidyEntities.get(0);
            }

            Object[] bodyArray = new Object[header.length];
            //Map<String,Object> resMap = new HashMap<>();
            for (int headerIndex = 0;headerIndex < header.length;headerIndex ++){

                String headerName = header[headerIndex];
                Object bodyObj = null;
                switch (headerName)
                {
                    case "name":
                        bodyObj = personEntity.getName();
                        //resMap.put(headerName,personEntity.getName());
                        break;
                    case "gender":
                        bodyObj = personEntity.getGender();
                        //resMap.put(headerName,personEntity.getGender());
                        break;
                    case "marry":
                        bodyObj = personEntity.getMarry();
                        //resMap.put(headerName,personEntity.getMarry());
                        break;
                    case "marryData":
                        bodyObj = personEntity.getMarryData();
                        //resMap.put(headerName,personEntity.getMarryData());
                        break;
                    case "joinData":
                        bodyObj = personEntity.getJoinData();
                        //resMap.put(headerName,personEntity.getJoinData());
                        break;
                    case "partLevel":
                        bodyObj = personEntity.getPartLevel();
                        //resMap.put(headerName,personEntity.getPartLevel());
                        break;
                    case "institute":
                        bodyObj = personEntity.getInstitute();
                        //resMap.put(headerName,personEntity.getInstitute());
                        break;
                    case "personLevel":
                        bodyObj = personEntity.getPersonLevel();
                        //resMap.put(headerName,personEntity.getPersonLevel());
                        break;
                    case "iscadre":
                        bodyObj = personEntity.isIscadre();
                        //resMap.put(headerName,personEntity.isIscadre());
                        break;
                    case "totalHoliday":
                        bodyObj = holidyEntity.getTotalHoliday();
                        //resMap.put(headerName,holidyEntity.getTotalHoliday());
                        break;
                    case "hasRestDay":
                        bodyObj = holidyEntity.getHasRestDay();
                        //resMap.put(headerName,holidyEntity.getHasRestDay());
                        break;
                    case "restRate":
                        bodyObj = holidyEntity.getRestRate();
                        //resMap.put(headerName,holidyEntity.getRestRate());
                        break;
                }
                bodyArray[headerIndex] = bodyObj;
            }
            resBodyArray.add(bodyArray);
            //resbody.add(resMap);
        }

        baseMessage.setCode(MessageCode.Success);
        personListResponseData.setM_body(resBodyArray);
        personListResponseData.setM_header(resHeader);
        return baseMessage.GetMessageJson();
    }


    public boolean IsPersonTableContain(String key)
    {
        String personTableStr = "name,gender,marry,startMarryData,endMarryData,startJoinData,endJoinData,partLevel,institute,personLevel,iscadre";
        return personTableStr.contains(key);
    }


}
