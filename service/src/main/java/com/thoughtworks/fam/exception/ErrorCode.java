package com.thoughtworks.fam.exception;

public enum ErrorCode
{
    //system level error
    UNKNOWN(0),

    //auth error
    UNAUTHORIZED(100),
    LOST_NECESSARY_AUTH_INFO(101),
    USER_NOT_EXIST(102),
    PASSWORD_NOT_MATCHED(103),

    //user error
    USER_NAME_CONFLICT(409);

    private final int code;

    private ErrorCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }
}
