package com.thoughtworks.fam.service;


import com.thoughtworks.fam.dao.AuthDAO;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthDAO authDAO;

    public UserDTO login(UserDTO user) {
        UserDTO loginUser = authDAO.getUser(user.getName());
        if(loginUser == null) {
            throw new RuntimeException("user is not exist.");
        }
        // TODO: Use MD5 or other encryption
        if(!user.getPassword().equals(loginUser.getPassword())) {
            throw new RuntimeException("user password is incorrect.");
        }
        return loginUser;
    }
}
