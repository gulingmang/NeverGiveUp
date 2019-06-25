package com.xiazhe.service;

import com.xiazhe.bean.User;
import com.xiazhe.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User selectByid(int id) {
        User userById = userMapper.getUserById(id);
        return userById;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        User user = userMapper.getUserByNameAndPassword(username, password);
        return user;
    }

    @Override
    public int getaddUser(String username, String password) {
        int i = userMapper.getaddUser(username, password);
        return i;
    }
}
