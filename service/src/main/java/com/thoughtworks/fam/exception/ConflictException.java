package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseResponseException
{
    public ConflictException()
    {
        super(HttpStatus.CONFLICT);
    }

    public ConflictException(ErrorCode errorCode, String errorMessages)
    {
        super(HttpStatus.CONFLICT, errorCode, errorMessages);
    }
}
