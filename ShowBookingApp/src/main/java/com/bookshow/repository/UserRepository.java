package com.bookshow.repository;

import com.bookshow.model.User;

public interface UserRepository {
    void addUser(User user);
    User getUser(String name);
}
