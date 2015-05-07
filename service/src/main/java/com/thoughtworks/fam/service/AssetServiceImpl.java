package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("assetService")
@Transactional
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public void saveAsset(Asset asset) {
        this.assetRepository.save(asset);
    }
}
