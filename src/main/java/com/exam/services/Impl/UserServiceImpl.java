package com.exam.services.Impl;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
      User local=  this.userRepository.findByUsername(user.getUsername());
      if(local!=null){
          System.out.println("User is already there !!");
          throw new Exception("User already present !!");
      }
      else{
          //user create
          for(UserRole ur:userRoles){
              roleRepository.save(ur.getRole());
          }
          local =this.userRepository.save(user);
      }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }


    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    @Override
    public User updateUser(Long userId, User updatedUser) {
        // Fetch the existing user entity from the database
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update the properties of the existing user entity
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setEnabled(updatedUser.isEnabled());
        user.setProfile(updatedUser.getProfile());
        // Update user roles if needed
        user.setUserRoles(updatedUser.getUserRoles());

        // Save the updated user entity back to the database
        return userRepository.save(user);
    }
}
