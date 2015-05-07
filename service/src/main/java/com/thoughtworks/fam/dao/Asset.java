package com.thoughtworks.fam.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TABLE_ASSETS")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSET_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_NUMBER")
    private String assetNumber;

    @Column(name = "ASSET_ASSIGNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;

    @Column(name = "ASSET_TYPE")
    private String assetType;

    protected Asset() {
    }

    public Asset(String assetName, String assetNumber, Date assignedDate, String assetType) {
        this.assetName = assetName;
        this.assetNumber = assetNumber;
        this.assignedDate = assignedDate;
        this.assetType = assetType;
    }

    public long getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", assetName='" + assetName + '\'' +
                ", assetNumber='" + assetNumber + '\'' +
                ", assignedDate=" + assignedDate +
                ", assetType='" + assetType + '\'' +
                '}';
    }
}
