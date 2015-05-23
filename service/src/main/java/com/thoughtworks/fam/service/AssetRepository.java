package com.thoughtworks.fam.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thoughtworks.fam.domain.Asset;

public interface AssetRepository extends CrudRepository<Asset, Long>
{
    Asset findByAssetNumber(String assetNumber);

    List<Asset> findByAccount(String account);
}
