package com.thoughtworks.fam.exception;

import java.util.Date;

public class ErrorInfo
{
    private long timestamp;
    private int httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

    public ErrorInfo(int httpStatus, ErrorCode errorCode, String errorMessage)
    {
        this.timestamp = new Date().getTime();
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public int getHttpStatus()
    {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus)
    {
        this.httpStatus = httpStatus;
    }
}
