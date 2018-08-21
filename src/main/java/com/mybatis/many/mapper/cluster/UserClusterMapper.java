package com.mybatis.many.mapper.cluster;

import java.util.List;
import com.mybatis.many.entity.User;

public interface UserClusterMapper {
    List<User> getAll();
    User insert(User user);
}
