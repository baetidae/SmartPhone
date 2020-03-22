package com.edu.controller;

import com.edu.entry.User;
import com.edu.service.UserService;
import com.edu.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")//和user相关的所有请求由这个控制器接收
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login/auth",produces = {"application/json;charset=UTF-8"})//处理post请求
    @ResponseBody//序列化——类型转换——jackson——json
    public ResponseMessage login(@RequestParam String tel,
                                 @RequestParam String password){
        User user = new User(tel,password);
        boolean result = userService.findUserWithTelAndPassword(user);
        return result ? ResponseMessage.success() : ResponseMessage.error();
    }


    @PostMapping("/register")
    @ResponseBody
    public ResponseMessage register(@RequestParam String tel,
                                    @RequestParam String password){
        //创建用户对象
        User user = new User(tel, password);
        //注册用户
        String result = userService.register(user);
        //判断结果
        if(result.contains("注册成功")){
            return ResponseMessage.success();
        }else {
            return ResponseMessage.error().addObject("msg",result);
        }
    }
}
