package com.mybatis.many.mapper.master;

import java.util.List;
import com.mybatis.many.entity.User;

public interface UserMasterMapper {
    List<User> getAll();
    User insert(User user);
}
