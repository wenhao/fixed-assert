package com.thoughtworks.fam.domain;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_ASSETS")
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSET_ID")
    private long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_NUMBER")
    private String assetNumber;

    @Column(name = "ASSIGNED_DATE")
    @Temporal(TemporalType.DATE)
    private String assignedDate;

    @Column(name = "ASSET_TYPE")
    private String assetType;

    public Asset(String assetName, String assetNumber, String assignedDate, String assetType)
    {

        this.assetName = assetName;
        this.assetNumber = assetNumber;
        this.assignedDate = assignedDate;
        this.assetType = assetType;
    }

    public String getAssetName()
    {
        return assetName;
    }

    public String getAssetNumber()
    {
        return assetNumber;
    }


    public String getAssetType()
    {
        return assetType;
    }

    public String getAssignedDate()
    {
        return assignedDate;
    }

    public long getId()
    {
        return id;
    }

    public User getUser()
    {
        return user;
    }
}
