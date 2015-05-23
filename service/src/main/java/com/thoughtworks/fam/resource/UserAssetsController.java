package com.thoughtworks.fam.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.service.AssetService;

@RestController
public class UserAssetsController
{
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/users/{account}/others/assets", method = RequestMethod.GET)
    public ResponseEntity<List<Asset>> getOthersAssets(@PathVariable String account)
    {
        List<Asset> assets = assetService.getOthersAssets(account);
        return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{account}/assets", method = RequestMethod.GET)
    public ResponseEntity<List<Asset>> getUserAssets(@PathVariable String account)
    {
        List<Asset> assets = assetService.getUserAssets(account);
        return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
    }
}
