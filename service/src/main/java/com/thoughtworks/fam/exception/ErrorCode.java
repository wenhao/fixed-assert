package com.thoughtworks.fam.exception;

public enum ErrorCode
{
    //system level error
    UNKNOWN,

    //auth error
    UNAUTHORIZED,
    USER_NOT_EXIST,
    PASSWORD_NOT_MATCHED,

    //user error
    ACCOUNT_EXISTED
}
