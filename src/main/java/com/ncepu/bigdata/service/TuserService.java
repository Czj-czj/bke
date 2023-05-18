package com.ncepu.bigdata.service;

import com.ncepu.bigdata.entity.SysUser;

import java.util.List;

public interface TuserService {
    public SysUser login(String uname, String pwd);
    public List<SysUser> getAll();
    public List<SysUser> getUser(String uname);
    public SysUser getUser(int uid);
    public void updateUser(SysUser sysUser);
    public void insertUser(SysUser sysUser);
    public void deleOne(int uid);
    public void deleSome(String[] uids);

}
