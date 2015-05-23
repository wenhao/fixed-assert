package com.thoughtworks.fam.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TABLE_ASSETS")
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSET_ID")
    private long id;

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "ASSET_NAME")
    @NotNull(message = "Name should not be null.")
    @Pattern(regexp = "^\\d{8}$", message = "Name should be made up of 8 numbers.")
    private String assetName;

    @Column(name = "ASSET_NUMBER")
    private String assetNumber;

    @Column(name = "ASSIGNED_DATE")
    private String assignedDate;

    @Column(name = "ASSET_TYPE")
    @NotNull(message = "Type should not be null.")
    private String assetType;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    public Asset()
    {
    }

    public Asset(String ownerName, String assetName, String assetNumber,
                 String assignedDate, String assetType)
    {
        this.ownerName = ownerName;
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

    public String getOwnerName()
    {
        return ownerName;
    }
}
