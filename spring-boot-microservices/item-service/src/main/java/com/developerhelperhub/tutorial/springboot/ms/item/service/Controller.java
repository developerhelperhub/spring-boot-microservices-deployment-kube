package com.developerhelperhub.tutorial.springboot.ms.item.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    @GetMapping("/items")
    public ItemListResponse hello() {
        List<ItemResponse> items = new ArrayList<>();
        items.add(ItemResponse.builder().id("100001").name("Item 1").build());
        items.add(ItemResponse.builder().id("100002").name("Item 2").build());
        return ItemListResponse.builder().items(items).build();
    }

}
