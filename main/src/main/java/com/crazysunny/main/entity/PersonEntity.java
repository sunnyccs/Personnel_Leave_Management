package com.crazysunny.main.entity;

import org.springframework.beans.factory.annotation.Value;

public class PersonEntity {

    private int id;

    //名字
    private String name;

    //头像
    private String headIcon;

    //性别
    private String gender;

    //是否结婚
    private int marry;

    //结婚日期
    private long marryData;

    //入伍时间
    private long joinData;

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

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
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

    public long getMarryData() {
        return marryData;
    }

    public void setMarryData(long marryData) {
        this.marryData = marryData;
    }

    public long getJoinData() {
        return joinData;
    }

    public void setJoinData(long joinData) {
        this.joinData = joinData;
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

    public Integer isIscadre() {
        return iscadre;
    }

    public void setIscadre(Integer iscadre) {
        this.iscadre = iscadre;
    }
}
