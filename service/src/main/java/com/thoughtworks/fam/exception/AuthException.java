package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthException extends BaseResponseException {
    public AuthException() {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.UNAUTHORIZED);
    }

    public AuthException(ErrorCode errorCode) {
        super(HttpStatus.UNAUTHORIZED, errorCode);
    }

    public AuthException(ErrorCode errorCode, String errorMessage) {
        super(HttpStatus.UNAUTHORIZED, errorCode, errorMessage);
    }
}
