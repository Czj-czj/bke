package com.ncepu.bigdata.service;

import com.ncepu.bigdata.entity.User;

public interface UserService {
    User login(String username, String password);

    User loginByID(String id, String password);

    void insert(User user);

}
