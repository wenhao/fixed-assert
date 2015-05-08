package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.User;


public interface UserService {
    User findByUserName(String userName);
    void saveUser(User user);
}
