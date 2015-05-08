package com.thoughtworks.fam.exception;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.http.HttpStatus;

/**
 * Created by zy on 2015/5/7.
 */
public class UserException extends BaseResponseException {
    public UserException(HttpStatus status) {
        super(status);
    }

    public UserException(ErrorCode errorCode,String errorMessages){
        super(HttpStatus.CONFLICT,errorCode,errorMessages);
    }
}
