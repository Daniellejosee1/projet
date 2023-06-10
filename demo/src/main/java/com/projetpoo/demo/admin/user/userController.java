package com.projetpoo.demo.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projet/admin/user")
public class userController {
 
    @Autowired
    private userService userService;
 
    @GetMapping("/{username}")
    public user getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
 
    @PostMapping("")
    public void createUser(@RequestBody user user) {
        userService.createUser(user);
    }
 
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody user user) {
        userService.updateUser(id, user);
    }
 
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
