package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.Asset;
import com.thoughtworks.fam.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
