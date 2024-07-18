package com.exam.services;

import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface UserService {

    //Creating user
    public User createUser (User user, Set<UserRole> userRoles) throws Exception;
    //when this is called in implementation then it will take two argument user and set of userroles.


    // get user by username
    public User getUser (String username);


    // delete user
    public void deleteUser(Long userId);

    //update
    public User updateUser(Long userId, User user);
}
