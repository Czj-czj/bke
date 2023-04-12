package com.example.servletImpl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
