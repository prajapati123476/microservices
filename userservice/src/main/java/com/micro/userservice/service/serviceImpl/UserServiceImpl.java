package com.micro.userservice.service.serviceImpl;

import com.micro.userservice.entities.User;
import com.micro.userservice.repositories.UserRepository;
import com.micro.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public User updateUser(User user, String userId) {
        //find user
        User oldUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("not found"));
        //set details
        oldUser.setName("abc");
        oldUser.setEmail("abc@gmai.com");
        oldUser.setAbout("i am dev");
        User updatedUser = userRepository.save(oldUser);
        return updatedUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
