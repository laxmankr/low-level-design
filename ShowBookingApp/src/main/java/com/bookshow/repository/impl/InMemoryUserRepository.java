package com.bookshow.repository.impl;

import com.bookshow.model.User;
import com.bookshow.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryUserRepository implements UserRepository {
    Map<String, User> users= new HashMap<>();
    @Override
    public void addUser(User user) {
        users.put(user.getUserName(), user);
    }

    @Override
    public User getUser(String name) {
        return users.get(name);
    }

}
