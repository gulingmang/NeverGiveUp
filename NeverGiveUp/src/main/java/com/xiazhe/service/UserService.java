package com.xiazhe.service;

import com.xiazhe.bean.User;


public interface UserService {
    public User selectByid(int id);

    public User getUserByNameAndPassword(String username, String password);

    int getaddUser(String username, String password);
}
