package com.learning.graphql.graphql_demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersInput {
    private String orderType;
    private String orderStatus;
}
