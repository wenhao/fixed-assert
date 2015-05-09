package com.thoughtworks.fam.resource.domain;

public class TempAsset
{
    private String assetName;
    private String assetNumber;
    private String assignedDate;
    private String assetType;

    public TempAsset(String assetName, String assetNumber, String assignedDate, String assetType)
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
