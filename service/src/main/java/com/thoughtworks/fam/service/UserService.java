package com.thoughtworks.fam.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;


@Service
public class UserService
{
    private static Map<String, User> users = new HashMap<String, User>();

    static {
        users.put("twer", new User("twer", "123456"));
    }

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void createUser(User user)
    {
        if (users.containsKey(user.getAccount())) {
            throw new ConflictException(ErrorCode.ACCOUNT_EXISTED, "account has existed.");
        }
        users.put(user.getAccount(), user);
    }

    public static Map<String, User> getUsers()
    {
        return users;
    }

    public User getUser(long uid)
    {
        return this.userRepository.findOne(uid);
    }
}
