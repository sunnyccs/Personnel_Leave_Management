package com.crazysunny.main.Tools;

import java.util.HashMap;
import java.util.Map;

public class PersonUtils {

    public static Map<String,String> personListHeader = new HashMap<>();

    public static Map<String ,String> getPersonListHeader()
    {
        if (personListHeader.size() > 0)
            return personListHeader;

        personListHeader.put("name","名字");
        personListHeader.put("gender","性别");
        personListHeader.put("marry","是否结婚");
        personListHeader.put("marryData","结婚时间");
        personListHeader.put("joinData","入伍时间");
        personListHeader.put("partLevel","部职别");
        personListHeader.put("institute","所属单位");
        personListHeader.put("personLevel","职级");
        personListHeader.put("iscadre","是否为干部");
        personListHeader.put("totalHoliday","总假期");
        personListHeader.put("hasRestDay","已休假期");
        personListHeader.put("restRate","休假率");
        return personListHeader;
    }
}
