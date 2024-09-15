package com.developerhelperhub.tutorial.springboot.ms.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class Controller {

    @GetMapping("/orders")
    public OrderListResponse orders() {
        log.info("Loading orders...");

        List<OrderResponse> items = new ArrayList<>();

        items.add(OrderResponse.builder().id("ORD00001").date("2001-10-23").build());
        items.add(OrderResponse.builder().id("ORD00002").date("2001-12-12").build());
        items.add(OrderResponse.builder().id("ORD00003").date("2002-01-03").build());

        log.info("Loaded orders {}", items.size());

        return OrderListResponse.builder().items(items).build();
    }

}
