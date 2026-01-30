package com.learning.graphql.graphql_demo.controller;

import com.learning.graphql.graphql_demo.entity.User;
import com.learning.graphql.graphql_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) throws  RuntimeException{
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not found with the id "+userId));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody  User user){
        if(user.getOrders() != null){
            user.getOrders().forEach(order -> order.setUser(user));
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userRepository.deleteById(userId);
    }


}
