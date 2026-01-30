package com.learning.graphql.graphql_demo.dto;

import com.learning.graphql.graphql_demo.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInput {
    private String userName;
    private String contact;
    private List<Orders> orders;
}
