package com.example.dao;

import com.example.entity.User;

public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
}
