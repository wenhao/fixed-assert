package com.thoughtworks.fam.exception;

public enum ErrorCode
{
    //system level error
    UNKNOWN,

    //auth error
    UNAUTHORIZED,
    LOST_NECESSARY_AUTH_INFO,
    USER_NOT_EXIST,
    PASSWORD_NOT_MATCHED,

    //user error
    USER_NAME_CONFLICT
}
