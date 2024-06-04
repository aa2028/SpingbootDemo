package com.softeem.springbootdemo.service.impl;

import com.softeem.springbootdemo.mapper.UserMapper;
import com.softeem.springbootdemo.pojo.User;
import com.softeem.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service//此解释不能忘记了..一定要添加
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;

    /**
     * 此方法检查用户输入的用户名与密码是否正确
     * @param user
     * @return 返回true表示成功[用户名密码正确],false表示失败[用户密码错误]
     */
    @Override
    public Map checkLogin(User user) {
        User u = userMapper.findUserByNameAndPassword(user);
        boolean b =  u != null ;
        String role = u.getRole();
        Map map = new HashMap();
        map.put("b" , b);
        map.put("role", role);
        return map ;
    }
}
