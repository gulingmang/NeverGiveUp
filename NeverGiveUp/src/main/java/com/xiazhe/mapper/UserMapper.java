package com.xiazhe.mapper;

import com.xiazhe.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User getUserById(int id);

    int getaddUser(@Param("username") String username, @Param("password") String password);

    public User getUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
