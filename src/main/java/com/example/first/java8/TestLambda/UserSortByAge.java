package com.example.first.java8.TestLambda;

import com.example.first.entity.User;

public class UserSortByAge implements MySort<User> {

    @Override
    public boolean sort(User user) {
        return user.getAge().compareTo(18) > 0;
    }
}
