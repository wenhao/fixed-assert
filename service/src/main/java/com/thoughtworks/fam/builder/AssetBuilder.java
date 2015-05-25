package com.thoughtworks.fam.builder;

import com.thoughtworks.fam.domain.Asset;

public class AssetBuilder
{
    private final Asset asset;

    public AssetBuilder()
    {
        asset = new Asset();
    }

    public AssetBuilder withAccount(String account)
    {
        asset.setAccount(account);
        return this;
    }

    public AssetBuilder withAssetName(String assetName)
    {
        asset.setAssetName(assetName);
        return this;
    }

    public AssetBuilder withAssetNumber(String assetNumber)
    {
        asset.setAssetNumber(assetNumber);
        return this;
    }

    public AssetBuilder withAssignedDate(String assignedDate)
    {
        asset.setAssignedDate(assignedDate);
        return this;
    }

    public AssetBuilder withAssetType(String assetType)
    {
        asset.setAssetType(assetType);
        return this;
    }

    public Asset build()
    {
        return asset;
    }
}
