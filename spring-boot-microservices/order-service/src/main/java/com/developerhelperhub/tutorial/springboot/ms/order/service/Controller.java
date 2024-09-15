package com.developerhelperhub.tutorial.springboot.ms.order.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    @GetMapping("/orders")
    public OrderListResponse hello() {
        List<OrderResponse> items = new ArrayList<>();
        items.add(OrderResponse.builder().id("ORD00001").date("2001-10-23").build());
        items.add(OrderResponse.builder().id("ORD00002").date("2001-12-12").build());
        return OrderListResponse.builder().items(items).build();
    }

}
