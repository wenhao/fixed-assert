package com.thoughtworks.fam.web.dto;

import java.util.Date;

public class Asset {
    private String name;
    private int number;
    private Date assignedDate;
    private String type;

    public Asset() {

    }

    public Asset(String name, int number, Date assignedDate, String type) {
        this.name = name;
        this.number = number;
        this.assignedDate = assignedDate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

