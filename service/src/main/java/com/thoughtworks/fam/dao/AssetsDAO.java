package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.Asset;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AssetsDAO {
    public List<Asset> getAllAssets() {
        return mockAssets();
    }

    private List<Asset> mockAssets() {
        List<Asset> assets = new ArrayList<Asset>();

        assets.add(new Asset("mac book pro",1,new Date(),"Laptop"));
        assets.add(new Asset("mac book air",1,new Date(),"Laptop"));

        return assets;
    }
}
