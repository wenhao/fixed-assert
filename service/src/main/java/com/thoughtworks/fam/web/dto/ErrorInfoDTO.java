package com.thoughtworks.fam.web.dto;

import com.thoughtworks.fam.exception.ErrorCode;

public class ErrorInfoDTO {
    private long timestamp;
    private int httpStatus;
    private ErrorCode code;
    private String errorMessage;

    public ErrorInfoDTO(long timestamp,int httpStatus, ErrorCode code, String errorMessage) {
        this.timestamp = timestamp;
        this.httpStatus =httpStatus;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
