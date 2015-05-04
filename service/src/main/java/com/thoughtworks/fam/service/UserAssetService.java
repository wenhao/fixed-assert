package com.thoughtworks.fam.service;

import com.thoughtworks.fam.web.dto.UserAssetDTO;

import java.util.List;

public interface UserAssetService {
    List<UserAssetDTO> getUserAssets(String userId);
}
