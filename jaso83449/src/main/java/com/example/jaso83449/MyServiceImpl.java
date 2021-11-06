package com.example.jaso83449;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl {
    public void update(User user) {
        userRepository.save(user);
      }
      public void updatee(Userdetail userdetail) {
        userdetailRepository.save(userdetail);
      }

}
