package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseResponseException extends RuntimeException
{
    private final HttpStatus status;
    private final ErrorCode errorCode;
    private final String errorMessage;

    protected BaseResponseException(HttpStatus status)
    {
        this(status, ErrorCode.UNKNOWN, "unknown error");
    }

    protected BaseResponseException(HttpStatus status, ErrorCode errorCode)
    {
        this(status, errorCode, errorCode.toString());
    }

    protected BaseResponseException(HttpStatus status, ErrorCode errorCode, String errorMessage)
    {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
}
