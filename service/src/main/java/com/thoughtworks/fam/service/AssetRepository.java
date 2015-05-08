package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<Asset, Long> {
}
