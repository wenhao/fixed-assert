package com.thoughtworks.fam.web.dto;

import com.thoughtworks.fam.dao.User;

import javax.persistence.*;
import java.util.Date;

public class AssetDTO {
    @Id
    @Column(name = "ASSET_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_NUMBER")
    private String assetNumber;

    @Column(name = "ASSET_ASSIGNED_DATE")
    private Date assignedDate;

    @Column(name = "ASSET_TYPE")
    private String assetType;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
