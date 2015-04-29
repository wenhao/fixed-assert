package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.AssetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AssetsDAO {
    public List<AssetDTO> getAllAssets() {
        return mockAssets();
    }

    private List<AssetDTO> mockAssets() {
        List<AssetDTO> assetDTOs = new ArrayList<AssetDTO>();

        assetDTOs.add(new AssetDTO("mac book pro",1,new Date(),"Laptop"));
        assetDTOs.add(new AssetDTO("mac book air",1,new Date(),"Laptop"));

        return assetDTOs;
    }
}
