package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("assetService")
@Transactional
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public void saveAsset(Asset asset) {
        this.assetRepository.save(asset);
    }
}
