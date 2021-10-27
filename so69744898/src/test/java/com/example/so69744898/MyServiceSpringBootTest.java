package com.example.so69744898;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MyServiceSpringBootTest {
  @MockBean
  MyDependency myDependency;

  @Autowired
  MyService myService;

  @Test
  void execute() {
    given(myDependency.execute("arg0")).willReturn(4);
    
    myService.execute("arg1"); //will return null
  }
}