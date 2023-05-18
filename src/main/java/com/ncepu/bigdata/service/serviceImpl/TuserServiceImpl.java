package com.ncepu.bigdata.service.serviceImpl;

import com.ncepu.bigdata.entity.SysUser;
import com.ncepu.bigdata.mapper.TuserMapper;
import com.ncepu.bigdata.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service//将当前类标识为逻辑层的类,此时spring容器中有了当前类
@Transactional//添加声明式事务,有了它就不需要考虑数据库的打开关闭

public class TuserServiceImpl implements TuserService {
    //@Autowired
    TuserMapper tuserMapper;
    @Override
    public SysUser login(String uname, String pwd) {
        return tuserMapper.login(uname,pwd);
    }

    @Override
    public List<SysUser> getAll() {
        return tuserMapper.getAll();
    }

    @Override
    public List<SysUser> getUser(String uname) {
        return tuserMapper.getUser(uname);
    }


    @Override
    public SysUser getUser(int uid) {
        return tuserMapper.getOne(uid);
    }


    @Override
    public void updateUser(SysUser sysUser) {
        tuserMapper.update(sysUser);
    }

    @Override
    public void insertUser(SysUser sysUser) {
        tuserMapper.insertUser(sysUser);
    }

    @Override
    public void deleOne(int uid) {
        tuserMapper.dele(uid);
    }

    @Override
    public void deleSome(String[] uids) {
        tuserMapper.deleSome(uids);
    }

}

