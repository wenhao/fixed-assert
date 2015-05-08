package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset, Long> {
}
