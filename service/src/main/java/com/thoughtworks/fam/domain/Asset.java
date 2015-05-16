package com.thoughtworks.fam.domain;

public class Asset
{
    private String assetName;
    private String assetNumber;
    private String assignedDate;
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
}
