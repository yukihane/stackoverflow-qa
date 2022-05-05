package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserImpl implements TestService {

    @Autowired
    UserDao dao;

    @Autowired
    @Qualifier("User")
    User user;

    @Override
    public List selectWhere(Object t) {

        User u = (User) t;

        List<User> list = dao.selectWhere(u);

        return list;

    }
}
