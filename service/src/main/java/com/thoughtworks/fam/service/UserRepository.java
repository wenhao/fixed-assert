package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByAccount(String account);
}
