package com.thoughtworks.fam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.domain.Asset;
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
    private final AssetRepository assetRepository;

    @Autowired
    public UserService(UserRepository userRepository, AssetRepository assetRepository)
    {
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
    }

    public List<Asset> getUserAssets()
    {
        List<Asset> assets = Lists.newArrayList(
                new Asset("twer", "Macbook", "123456", "2015-05-08", "Laptop"),
                new Asset("shuiqiang", "iPhone", "123457", "2015-05-09", "Mobile"),
                new Asset("kaihu", "Macbook", "223457", "2015-02-09", "Laptop"),
                new Asset("water", "Macbook", "323457", "2015-03-09", "Laptop"),
                new Asset("wrongkey", "IPad", "423457", "2015-04-09", "Pad")
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

    public List<Asset> getAssets(long uid)
    {
        return this.assetRepository.findByUser(getUser(uid));
    }

    public User getUser(long uid)
    {
        return this.userRepository.findOne(uid);
    }
}
