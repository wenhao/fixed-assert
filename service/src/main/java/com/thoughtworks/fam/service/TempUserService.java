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
        List<TempAsset> assets = Lists.newArrayList(
                new TempAsset("Macbook", "123456", "2015-05-08", "Laptop"),
                new TempAsset("iPhone", "123457", "2015-05-09", "Mobile")
        );
        return assets;
    }

}
