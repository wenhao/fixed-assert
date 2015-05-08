package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import com.thoughtworks.fam.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, AssetRepository assetRepository) {
        this.userRepository = repository;
        this.assetRepository = assetRepository;
    }

    @Override
    public User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public List<Asset> getUserAssets(String userName) {
        return this.assetRepository.findByUserName(userName);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
