package com.thoughtworks.fam.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;

public interface AssetRepository extends CrudRepository<Asset, Long>
{
    List<Asset> findByUser(User user);
}
