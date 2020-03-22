package com.edu.service;


import com.edu.dao.UserMapper;
import com.edu.entry.User;
import com.edu.entry.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean findUserWithTelAndPassword(User user){

        //创建一个条件对象
       UserExample userExample = new UserExample();
       userExample.createCriteria().andTelEqualTo(user.getTel())
                .andPasswordEqualTo(user.getPassword());

        //查询数据
        List<User> userList = userMapper.selectByExample(userExample);
        //判断返回结果
        return userList != null && userList.size() == 1;
    }

    public String register(User user){
        //验证账号是否存在
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelEqualTo(user.getTel());

        //根据条件对象查询数据
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList.size()>0 && userList!= null){
            return "用户存在，注册失败";
        }
        //添加用户
        userMapper.insertSelective(user);
        return "注册成功";
    }

}
