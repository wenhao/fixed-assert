package com.thoughtworks.fam.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;

@Service
public class AssetService
{
    private static List<Asset> assets = new LinkedList<>();

    static {
        assets.add(new Asset("12345678", "123321",
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
}
