package com.thoughtworks.fam.service;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.resource.domain.TempAsset;

import java.util.List;

/**
 * Created by water on 15-5-9.
 */
class TempUserService
{
    public List<TempAsset> getAssets()
    {
        List<TempAsset> assets = Lists.newArrayList();
        assets.add(new TempAsset("Macbook", "123456", "2015-05-08", "Laptop"));
        return assets;
    }

}
