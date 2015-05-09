package com.thoughtworks.fam.service;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.resource.domain.TempAsset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempUserService
{
    public List<TempAsset> getAssets()
    {
        List<TempAsset> assets = Lists.newArrayList();
        assets.add(new TempAsset("Macbook", "123456", "2015-05-08", "Laptop"));
        return assets;
    }

}
