package com.example.so69744898;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {
  @Mock
  MyDependency myDependency;

  @InjectMocks
  MyService myService;

  @Test
  void execute() {
    given(myDependency.execute("arg0")).willReturn(4);
    
    myService.execute("arg1"); //will throw exception
  }
}
