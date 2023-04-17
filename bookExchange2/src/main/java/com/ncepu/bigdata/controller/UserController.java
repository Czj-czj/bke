package com.ncepu.bigdata.controller;

import com.ncepu.bigdata.entity.Res;
import com.ncepu.bigdata.entity.User;
import com.ncepu.bigdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    UserService userserviceImpl;
    @GetMapping("/user")
    public User getUserInfo(@RequestParam("openid") String id,@RequestParam("password") String password) {
        // 根据 openid 查询用户信息，并返回 User 对象
        User user=userserviceImpl.login(id,password);
        return user;
    }
    @GetMapping("/userbyid")
    public User getUserInfoById(@RequestParam("openid") String id,@RequestParam("password") String password) {
        // 根据 openid 查询用户信息，并返回 User 对象
        User user=userserviceImpl.login(id,password);
        return user;
    }

    @GetMapping("/getSecret")
    public Res getSecret(@RequestParam("openid") String openid){
        Res res=new Res();
        if(openid.equals("wx4e5fa15c856d452f")){
            res.setRight(true);
            res.setResult("230581971a33a589b2ffc3cbd4bc1da7");
        }
        return res;
    }

    @GetMapping("/updateUser")
    public boolean upU(@RequestParam("username") String username,@RequestParam("password") String pwd,@RequestParam("email") String email){
        User user = new User(username, pwd, email);
        userserviceImpl.insert(user);
        return true;
    }

}