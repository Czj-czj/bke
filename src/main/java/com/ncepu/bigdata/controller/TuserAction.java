package com.ncepu.bigdata.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncepu.bigdata.entity.SysUser;
import com.ncepu.bigdata.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TuserAction {
    //@Autowired
    TuserService tuserserviceImpl;
    /*
     *
     * @param go
     * @return
     * */
    @RequestMapping("/go")
    public String go(String go) {
        return go;
    }


    @RequestMapping("/login")
    public String login(String username, String password) {
        SysUser sysUser=tuserserviceImpl.login(username,password);
        String result="";
        if(sysUser==null){
            result="login.html";
        }else{
            result="main.html";
        }
        return result;
    }
    @RequestMapping("/getAll")
    public String getAll(Model model, Integer page){
        List<SysUser> users=tuserserviceImpl.getAll();
        if(page==null)
            page=1;
        PageHelper.startPage(page,1);
        PageInfo<SysUser> pageInfo=new PageInfo<>(users);
        model.addAttribute("info",pageInfo);
        model.addAttribute("us",users);
        return "user/userList.html";
    }



    @RequestMapping("/getuser")
    public String getUser(String username,Model model){
        List<SysUser> users = tuserserviceImpl.getUser(username);
        model.addAttribute("us",users);
        return "user/userList.html";
    }



    @RequestMapping("/deleOne")
    public String deleOne(int uid){
        tuserserviceImpl.deleOne(uid);
        return "forward:/getAll";
    }

    @RequestMapping("/deleteUsers")
    public String deleSome(String uids){
        String[] ids=uids.split(",");
        tuserserviceImpl.deleSome(ids);
        return "forward:/getAll";
    }
}
