/*
* 休假记录表，记录每个成员休假的详细数据
* */
package com.crazysunny.main.entity;

public class LeaveRecordEntity {

    private int id;

    private int personID;

    private long startTime;

    private long endTime;

    private int holidayType;

    private String holidayPlace;

    private float roadCostTime;

    private int isFree;

    private float freeeRest;

    private String remarks;

    private long createDate;

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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(int holidayType) {
        this.holidayType = holidayType;
    }

    public String getHolidayPlace() {
        return holidayPlace;
    }

    public void setHolidayPlace(String holidayPlace) {
        this.holidayPlace = holidayPlace;
    }

    public float getRoadCostTime() {
        return roadCostTime;
    }

    public void setRoadCostTime(float roadCostTime) {
        this.roadCostTime = roadCostTime;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public float getFreeeRest() {
        return freeeRest;
    }

    public void setFreeeRest(float freeeRest) {
        this.freeeRest = freeeRest;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
