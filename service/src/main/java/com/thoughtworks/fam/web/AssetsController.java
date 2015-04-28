package com.thoughtworks.fam.web;

import com.thoughtworks.fam.web.dto.AssetDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/assets")
public class AssetsController {

    @RequestMapping(method = RequestMethod.GET)
    public AssetDTO onAssetsView() {
        AssetDTO dto = new AssetDTO();
        dto.setName("MacBook");
        dto.setNumber(1700160169);
        dto.setAssignedDate(new Date(20150425));
        dto.setType("laptop");
        return dto;
    }
}
