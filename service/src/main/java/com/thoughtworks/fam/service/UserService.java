package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import com.thoughtworks.fam.dao.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);
    void saveUser(User user);
}
