package com.thoughtworks.fam.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;

@Service
public class AssetService
{
    private static List<Asset> assets = new LinkedList<Asset>();

    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository)
    {
        this.assetRepository = assetRepository;
    }

    static {
        assets.add(new Asset("twer", "12345678", "123321",
                "Apple Laptop", new Date().toString()));
    }

    public void createAsset(Asset asset)
    {
        if (!isAssetNameAvailable(asset.getAssetName())) {
            throw new ConflictException(ErrorCode.ASSET_NAME_EXISTED,
                    "The name already exist, please use another one.");
        }

        assets.add(asset);
    }

    private boolean isAssetNameAvailable(final String assetName)
    {
        for (Asset asset : assets) {
            if (assetName.equals(asset.getAssetName())) {
                return false;
            }
        }

        return true;
    }

    public static List<Asset> getAssets()
    {
        return assets;
    }

    public List<Asset> getOthersAssets()
    {
        List<Asset> assets = Lists.newArrayList(
                new Asset("twer", "Macbook", "123456", "2015-05-08", "Laptop"),
                new Asset("shuiqiang", "iPhone", "123457", "2015-05-09", "Mobile"),
                new Asset("kaihu", "Macbook", "223457", "2015-02-09", "Laptop"),
                new Asset("water", "Macbook", "323457", "2015-03-09", "Laptop"),
                new Asset("wrongkey", "IPad", "423457", "2015-04-09", "Pad")
        );
        return assets;
    }

    public List<Asset> getUserAssets(long uid)
    {
        List<Asset> assets = Lists.newArrayList(
                new Asset("twer", "Macbook", "123456", "2015-05-08", "Laptop"),
                new Asset("twer", "Macbook", "223456", "2015-05-08", "Laptop")
        );
        return assets;
//        return this.assetRepository.findByUser(getUser(uid));
    }
}
