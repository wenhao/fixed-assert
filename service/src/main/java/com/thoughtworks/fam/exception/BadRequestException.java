package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseResponseException
{
    public BadRequestException()
    {
        super(HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(ErrorCode errorCode)
    {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }

    public BadRequestException(ErrorCode errorCode, String errorMessage)
    {
        super(HttpStatus.BAD_REQUEST, errorCode, errorMessage);
    }
}
