package com.ncepu.bigdata.service.serviceImpl;

import com.ncepu.bigdata.entity.SysUser;
import com.ncepu.bigdata.entity.User;
import com.ncepu.bigdata.mapper.TuserMapper;
import com.ncepu.bigdata.mapper.UserMapper;
import com.ncepu.bigdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service//将当前类标识为逻辑层的类,此时spring容器中有了当前类
@Transactional//添加声明式事务,有了它就不需要考虑数据库的打开关闭
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String id, String pwd) {
        return userMapper.login(id,pwd);
    }

    @Override
    public void insert(User user) {
        userMapper.insertUser(user);
    }
}
