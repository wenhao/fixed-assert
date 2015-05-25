package com.thoughtworks.fam.builder;

import com.thoughtworks.fam.domain.User;

public class UserBuilder
{
    private final User user;

    public UserBuilder()
    {
        user = new User();
    }

    public UserBuilder withAccount(String account)
    {
        user.setAccount(account);
        return this;
    }

    public UserBuilder withPassword(String password)
    {
        user.setPassword(password);
        return this;
    }

    public User build()
    {
        return user;
    }
}
