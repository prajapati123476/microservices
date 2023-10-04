package com.micro.userservice.service;

import com.micro.userservice.entities.User;

import java.util.List;

public interface UserService  {

    User saveUser(User user);
    User getUser(String userId);
    User updateUser(User user, String userId);
    List<User> getAllUser();
    void deleteUser(String userId);

}
