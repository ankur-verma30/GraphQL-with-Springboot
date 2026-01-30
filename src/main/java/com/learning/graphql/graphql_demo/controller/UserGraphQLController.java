package com.learning.graphql.graphql_demo.controller;


import com.learning.graphql.graphql_demo.dto.UserInput;
import com.learning.graphql.graphql_demo.entity.User;
import com.learning.graphql.graphql_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

    private final UserRepository userRepository;

    @QueryMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @QueryMapping
    public User getUserById(@Argument Integer userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }


    @MutationMapping
    public User createUser(@Argument UserInput userInput) {

        User user = User.builder()
                .userName(userInput.getUserName())
                .contact(userInput.getContact())
                .build();

        // set orders + link user in each order (important)
        if (userInput.getOrders() != null) {
            userInput.getOrders().forEach(order -> order.setUser(user));
            user.setOrders(userInput.getOrders());
        }

        return userRepository.save(user);
    }


@MutationMapping
public String deleteUser(@Argument Integer userId){
    userRepository.deleteById(userId);
    return "User is deleted successfully";
}

}
