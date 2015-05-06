package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
