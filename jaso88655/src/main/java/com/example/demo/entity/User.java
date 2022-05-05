package com.example.demo.entity;


import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component("User")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    private int userId;
    private int pass;
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getPass() {
        return pass;
    }
    public void setPass(int pass) {
        this.pass = pass;
    }

}

