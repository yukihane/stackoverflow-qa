package com.example.jaso83436;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyServiceImpl {
    
    private final UserRepository userRepository;

    public User doubleCheck(String id) {

        User u = userRepository.getById(id);

        if (u.getId().equals(id)) {
        //if (null != u) {
            return u;
        }
        return null;
    }


}
