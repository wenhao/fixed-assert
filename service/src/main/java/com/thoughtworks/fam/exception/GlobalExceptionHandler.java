package com.thoughtworks.fam.exception;

import com.thoughtworks.fam.web.dto.ErrorInfoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public ErrorInfoDTO handleAuthException(AuthException ex) {
        return new ErrorInfoDTO(new Date().getTime(), ex.getStatus().value(), ex.getErrorCode(), ex.getErrorMessage());
    }
}
