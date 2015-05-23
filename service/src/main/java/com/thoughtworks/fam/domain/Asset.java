package com.thoughtworks.fam.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TABLE_ASSETS")
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSET_ID")
    private long id;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_NUMBER")
    @NotNull(message = "Number should not be null.")
    @Pattern(regexp = "^\\d{8}$", message = "Number should be made up of 8 numbers.")
    private String assetNumber;

    @Column(name = "ASSIGNED_DATE")
    private String assignedDate;

    @Column(name = "ASSET_TYPE")
    @NotNull(message = "Type should not be null.")
    private String assetType;

    public Asset()
    {
    }

    public Asset(String account, String assetName, String assetNumber,
                 String assignedDate, String assetType)
    {
        this.account = account;
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

    public String getAccount()
    {
        return account;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Asset)){
            return false;
        }
        Asset other = (Asset) obj;
        return this.assetNumber.equals(other.assetNumber);
    }
}
