package com.example.so69744898;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public 
  class MyService {
    @Autowired MyDependency myDependency;

    Integer execute(String param) {
      return myDependency.execute(param);
    }
  } 