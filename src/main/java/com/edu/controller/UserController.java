package com.edu.controller;

import com.edu.entry.User;
import com.edu.service.UserService;
import com.edu.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
//和user相关的所有请求由这个控制器接收
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login/auth", produces = {"application/json;charset=UTF-8"})//处理post请求
    @ResponseBody//序列化——类型转换——jackson——json
    public ResponseMessage login(@RequestParam String tel,
                                 @RequestParam String password) {
        User user = new User(tel, password);
        List<User> userList = userService.findUserWithTelAndPassword(user);
        if(userList != null && userList.size() == 1){
            //用户存在
           //将用户添加到ResponseMessage中
            User result = userList.get(0);
            return ResponseMessage.success().addObject("User",result);
            //return ResponseMessage.success();
        } else {
            //用户不存在
          return ResponseMessage.error();
        }
    }


    @PostMapping("/register")
    @ResponseBody
    public ResponseMessage register(@RequestParam String tel,
                                    @RequestParam String password) {
        //创建用户对象
        User user = new User(tel, password);
        //注册用户
        String result = userService.register(user);
        //判断结果
        if (result.contains("注册成功")) {
            return ResponseMessage.success();
        } else {
            return ResponseMessage.error().addObject("msg", result);
        }
    }


}