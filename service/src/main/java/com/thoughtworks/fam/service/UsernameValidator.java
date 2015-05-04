package com.thoughtworks.fam.service;

import java.util.ArrayList;
import java.util.List;

public class UsernameValidator {

    // Linesh: 现在都返回true，因为邮箱验证不在故事卡#6的范围内。
    //   Story细节见: https://trello.com/c/AoTEWkHZ/15-6-create-a-new-user
    //
    // Linesh: returns true for now when I am doing this card #6 since validating is out of scope
    //   Story details: https://trello.com/c/AoTEWkHZ/15-6-create-a-new-user
    public static boolean isValidatedUserName(String username) {
        return true;
    }

    private static final List<String> VALIDATED_USERNAME = new ArrayList<String>();

    {
        VALIDATED_USERNAME.add("jtao@thoughtworks.com");
        VALIDATED_USERNAME.add("hwen@thoughtworks.com");
        VALIDATED_USERNAME.add("qianyan@thoughtworks.com");
        VALIDATED_USERNAME.add("sqlin@thoughtworks.com");
        VALIDATED_USERNAME.add("swli@thoughtworks.com");
        VALIDATED_USERNAME.add("leewin@thoughtworks.com");
        VALIDATED_USERNAME.add("khu@thoughtworks.com");
        VALIDATED_USERNAME.add("cylin@thoughtworks.com");
        VALIDATED_USERNAME.add("xsun@thoughtworks.com");
        VALIDATED_USERNAME.add("wenjie@thoughtworks.com");
        VALIDATED_USERNAME.add("yzhou@thoughtworks.com");
    }
}
