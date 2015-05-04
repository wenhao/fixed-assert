package com.thoughtworks.fam.service;

public class UserCreationServiceImpl implements UserCreationService{
    @Override
    public boolean isValidUsername(String username) {
        if (username.equals("hello")) return false;
        else return true;
    }
}
