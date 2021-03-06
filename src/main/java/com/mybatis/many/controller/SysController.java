package com.mybatis.many.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.many.entity.User;
import com.mybatis.many.service.cluster.UserClusterService;
import com.mybatis.many.service.master.UserMasterService;

import java.util.List;

@Controller
public class SysController {
    @Autowired
    private UserMasterService userMasterService;
    
    @Autowired
    private UserClusterService userClusterService;

    @ResponseBody
    @RequestMapping(value="/getAllUser")
    public List<User> getAllUser(Integer page, Integer rows) {
        return userMasterService.getAllUser();
    }
    
    @ResponseBody
    @RequestMapping(value="/getAll")
    public List<User> getAll(Integer page, Integer rows) {
    	return userClusterService.getAll();
    }
}
