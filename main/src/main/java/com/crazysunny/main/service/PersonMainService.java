package com.crazysunny.main.service;

import com.crazysunny.main.entity.PersonEntity;
import com.crazysunny.main.mapper.PersonMapper;
import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.message.MessageCode;
import com.crazysunny.main.message.response.PersonDetailInfoResponseData;
import com.crazysunny.main.message.response.PersonMainResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonMainService {

    private static final int page_count = 10;
    private static final String offsetStr = "offset";
    private static final String limitStr = "limit";
    @Autowired
    private PersonMapper personMapper;

    public BaseMessage GetMainResponseData(Map<String,Object> selectParam,int pageIndex)
    {
        Map<String,Object> selectParamMap = selectParam;//new HashMap<>();

        int paramSize = selectParam.size();

        int total = personMapper.getPersonCount(selectParamMap);
        int offset = page_count * pageIndex;
        selectParamMap.put(limitStr,page_count);
        selectParamMap.put(offsetStr,offset);
        List<PersonEntity> personEntities = personMapper.selectByMutilParams(selectParamMap);
        PersonMainResponseData responseData = new PersonMainResponseData();
        responseData.setM_body(personEntities);
        responseData.setTotalPage((int)Math.ceil((double) ((total * 1.0) / page_count)));
        BaseMessage baseMessage = responseData.CreateMessage();
        baseMessage.setCode(MessageCode.Success);
        return baseMessage;
    }

    public BaseMessage GetPersonInfoByID(int personID)
    {
        PersonEntity personEntity = personMapper.getPersonInfoByID(personID);

        PersonDetailInfoResponseData responseData = new PersonDetailInfoResponseData();
        responseData.setPersonEntity(personEntity);
        BaseMessage baseMessage = responseData.CreateMessage();
        baseMessage.setCode(MessageCode.Success);
        return baseMessage;
    }


}
