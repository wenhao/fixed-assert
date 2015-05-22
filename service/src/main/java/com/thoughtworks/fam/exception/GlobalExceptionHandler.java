package com.thoughtworks.fam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BaseResponseException.class)
    public ResponseEntity<ErrorInfo> handleException(BaseResponseException ex)
    {
        ErrorInfo errorInfo = new ErrorInfo(ex.getStatus().value(),
                ex.getErrorCode(), ex.getErrorMessage());

        return new ResponseEntity<>(errorInfo, ex.getStatus());
    }
}
