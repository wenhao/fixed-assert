package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationException extends BaseResponseException
{
    public AuthenticationException()
    {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.UNAUTHORIZED);
    }

    public AuthenticationException(ErrorCode errorCode)
    {
        super(HttpStatus.UNAUTHORIZED, errorCode);
    }

    public AuthenticationException(ErrorCode errorCode, String errorMessage)
    {
        super(HttpStatus.UNAUTHORIZED, errorCode, errorMessage);
    }
}
