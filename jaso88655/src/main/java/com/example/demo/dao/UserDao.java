package com.example.demo.dao;

import com.example.demo.entity.User;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public List<User> selectWhere(User u) {
        return List.of();
    }
}
