package com.thoughtworks.fam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;


@Service
public class UserService
{
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("twer", new User("twer", "123456"));
    }

    public List<Asset> getAssets()
    {
        List<Asset> assets = Lists.newArrayList(
                new Asset("Macbook", "123456", "2015-05-08", "Laptop"),
                new Asset("iPhone", "123457", "2015-05-09", "Mobile")
        );
        return assets;
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
}
