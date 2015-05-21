package com.thoughtworks.fam.service;

import org.springframework.data.repository.CrudRepository;
import com.thoughtworks.fam.domain.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByAccount(String account);
}
