package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AssetsDAO;
import com.thoughtworks.fam.web.dto.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssetsService {
    @Autowired
    private AssetsDAO assetsDAO;
    public List<Asset> getAllAssets() {
        return assetsDAO.getAllAssets();
    }
}
