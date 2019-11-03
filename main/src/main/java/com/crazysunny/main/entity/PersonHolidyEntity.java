/*
* 个人休假信息表
* */
package com.crazysunny.main.entity;

public class PersonHolidyEntity {

    private int id;

    private int personID;

    private String holidayStruct;

    private float totalHoliday;

    private float hasRestDay;

    private float restRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getHolidayStruct() {
        return holidayStruct;
    }

    public void setHolidayStruct(String holidayStruct) {
        this.holidayStruct = holidayStruct;
    }

    public float getTotalHoliday() {
        return totalHoliday;
    }

    public void setTotalHoliday(float totalHoliday) {
        this.totalHoliday = totalHoliday;
    }

    public float getHasRestDay() {
        return hasRestDay;
    }

    public void setHasRestDay(float hasRestDay) {
        this.hasRestDay = hasRestDay;
    }

    public float getRestRate() {
        return restRate;
    }

    public void setRestRate(float restRate) {
        this.restRate = restRate;
    }
}
