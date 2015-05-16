package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public class UserException extends BaseResponseException
{
    public UserException(HttpStatus status)
    {
        super(status);
    }

    public UserException(ErrorCode errorCode, String errorMessages)
    {
        super(HttpStatus.CONFLICT, errorCode, errorMessages);
    }
}
