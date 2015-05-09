package com.thoughtworks.fam.resource;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.resource.domain.TempAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/users/")
public class TempUserController
{
    @Autowired
    private TempUserService userService;

    @RequestMapping(value = "uid/assets", method = RequestMethod.GET)
    public ResponseEntity<List<TempAsset>> getUserAssets() throws ParseException
    {
        List<TempAsset> assets = userService.getAssets();
        return new ResponseEntity<List<TempAsset>>(assets, HttpStatus.OK);
    }

}

class TempUserService
{
    public List<TempAsset> getAssets()
    {
        List<TempAsset> assets = Lists.newArrayList();
        assets.add(new TempAsset("Macbook", "123456", "2015-05-08", "Laptop"));
        return assets;
    }

}
