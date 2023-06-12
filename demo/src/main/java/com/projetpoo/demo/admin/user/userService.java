package com.projetpoo.demo.admin.user;

public interface userService {

    user findByUsername(String username);

    void createUser(user user);
 
    void updateUser(Long id, user user);
 
    void deleteUser(Long id);
}
