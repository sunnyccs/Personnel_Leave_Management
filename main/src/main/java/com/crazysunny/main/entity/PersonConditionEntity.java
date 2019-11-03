package com.crazysunny.main.entity;

public class PersonConditionEntity {

    private int id;

    //名字
    private String name;

    //性别
    private String gender;

    //是否结婚
    private int marry;

    //结婚日期
    private long startMarryData;


    private long endMarryData;

    //入伍时间
    private long startJoinData;


    private long endJoinData;


    //部职别
    private String partLevel;

    //所属单位
    private String institute;

    //职级或者相当职级
    private String personLevel;

    //是否为干部
    private Integer iscadre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMarry() {
        return marry;
    }

    public void setMarry(int marry) {
        this.marry = marry;
    }

    public long getStartMarryData() {
        return startMarryData;
    }

    public void setStartMarryData(long startMarryData) {
        this.startMarryData = startMarryData;
    }

    public long getEndMarryData() {
        return endMarryData;
    }

    public void setEndMarryData(long endMarryData) {
        this.endMarryData = endMarryData;
    }

    public long getStartJoinData() {
        return startJoinData;
    }

    public void setStartJoinData(long startJoinData) {
        this.startJoinData = startJoinData;
    }

    public long getEndJoinData() {
        return endJoinData;
    }

    public void setEndJoinData(long endJoinData) {
        this.endJoinData = endJoinData;
    }

    public String getPartLevel() {
        return partLevel;
    }

    public void setPartLevel(String partLevel) {
        this.partLevel = partLevel;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getPersonLevel() {
        return personLevel;
    }

    public void setPersonLevel(String personLevel) {
        this.personLevel = personLevel;
    }

    public Integer getIscadre() {
        return iscadre;
    }

    public void setIscadre(Integer iscadre) {
        this.iscadre = iscadre;
    }
}
