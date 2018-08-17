package com.mybatis.many.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.many.annotation.TargetDataSource;
import com.mybatis.many.entity.User;
import com.mybatis.many.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @TargetDataSource(dataSource = "DataSource")
    public boolean createUser(User user) {
        userMapper.insert(user);
        return true;
    }
    
    public List<User> getAllUser() {
        return userMapper.getAll();
    }
    
    @Transactional
    @TargetDataSource(dataSource = "DataSourceDs1")
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
