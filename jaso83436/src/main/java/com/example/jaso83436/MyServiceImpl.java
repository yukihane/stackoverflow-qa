package com.example.jaso83436;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyServiceImpl {
    
    private final UserRepository userRepository;

        public User doubleCheck(String id) {
            try {
              User u = userRepository.getById(id);
              u.getName();
              return u;
            } catch (Exception e) {
              return null;
            }
    }


}
