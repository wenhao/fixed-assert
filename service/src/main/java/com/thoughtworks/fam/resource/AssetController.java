package com.thoughtworks.fam.resource;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.BadRequestException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.service.AssetService;

@RestController
@RequestMapping(value = "/asset")
public class AssetController
{
    @Autowired
    private AssetService assetService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody Asset asset, BindingResult result)
    {
        handleRequestParamError(result.getFieldErrors());

        assetService.createAsset(asset);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    private void handleRequestParamError(List<FieldError> errors)
    {
        for (FieldError error : errors) {
            if (error.getField().equals("assetNumber")) {
                throw new BadRequestException(
                        ErrorCode.INVALID_ASSET_NUMBER, error.getDefaultMessage());
            }
            if (error.getField().equals("assetType")) {
                throw new BadRequestException(
                        ErrorCode.INVALID_ASSET_TYPE, error.getDefaultMessage());
            }
        }
    }
}
