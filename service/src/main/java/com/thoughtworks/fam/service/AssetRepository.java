package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset, Long>
{
    List<Asset> findByUser(User user);
}
