package com.example.jaso83449;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyServiceImpl {
    
    private final UserRepository userRepository;
    private final UserdetailRepository userdetailRepository;
    
    public void update(User user) {
        userRepository.save(user);
      }
      public void updatee(Userdetail userdetail) {
        userdetailRepository.save(userdetail);
      }
    public Optional<User> selectById(String id) {
        return userRepository.findById(id);
    }

}
