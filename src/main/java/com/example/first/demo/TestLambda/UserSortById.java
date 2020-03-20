package com.example.first.demo.TestLambda;

import com.example.first.entity.User;

public class UserSortById implements MySort<User> {

    @Override
    public boolean sort(User user) {

        return user.getId().compareTo("2") > 0;
    }

}
