package com.thoughtworks.fam.service;


import com.thoughtworks.fam.dao.AuthDAO;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthDAO authDAO;

    public UserDTO login(UserDTO loginUser) {
        UserDTO user = authDAO.getUser(loginUser.getName());
        if(user == null) {
            throw new AuthException(ErrorCode.USER_NOT_EXIST,"The user is not exist.");
        }

        if(!user.getPassword().equals(loginUser.getPassword())){
            throw new AuthException(ErrorCode.PASSWORD_NOT_MATCHED,"The password is not correct, please input again.");
        }

        return user;
    }
}
