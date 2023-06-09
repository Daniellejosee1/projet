package com.projetpoo.demo.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private userRepository userRepository;

    @Override
    public user findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
 
    @Override
    public void createUser(user user) {
        userRepository.save(user);
    }
 
    @Override
    public void updateUser(Long id, user user) {
        user existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
