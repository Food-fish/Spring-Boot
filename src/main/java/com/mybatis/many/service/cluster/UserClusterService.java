package com.mybatis.many.service.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.many.entity.User;
import com.mybatis.many.mapper.cluster.UserClusterMapper;

import java.util.List;

@Service("UserClusterService")
public class UserClusterService {

    @Autowired
    private UserClusterMapper userMapper;

    @Transactional
    public boolean createUser(User user) {
        userMapper.insert(user);
        return true;
    }
    
    public List<User> getAllUser() {
        return userMapper.getAll();
    }
    
    @Transactional                                                                                                                                                                                                                                                   
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
