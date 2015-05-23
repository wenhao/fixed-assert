package com.thoughtworks.fam.exception;

public enum ErrorCode
{
    //system level error
    UNKNOWN,

    //auth error
    UNAUTHORIZED,
    USER_NOT_EXIST,
    PASSWORD_NOT_MATCHED,

    //asset error
    INVALID_ASSET_NUMBER,
    ASSET_NUMBER_EXISTED,

    INVALID_ASSET_TYPE, //user error
    ACCOUNT_EXISTED
}
