package com.example.jaso83310;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findBynameLike(String name){
    return userRepository.findBynameLike(name + "%");
    }

    public List<User> findAll() {
      return userRepository.findAll();
  }

    public void insert(User user) {
      userRepository.save(user);
    }

    public void update(User user) {
      userRepository.save(user);
    }

    public void delete(String id) {
      userRepository.deleteById(id);
    }

    public Optional<User> selectById(String id) {
        return userRepository.findById(id);
    }

    public User Login(String id,String pass) {
      User u = userRepository.getById(id);
      if (null != u) {
        if (u.getPass().equals(pass)) {
          return u;
        }
      } else {
      }
      return null;
    }
}
