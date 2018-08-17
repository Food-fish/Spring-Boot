package com.mybatis.many.mapper;

import java.util.List;
import com.mybatis.many.entity.User;

public interface UserMapper {
    List<User> getAll();
    User insert(User user);
}
