package com.developerhelperhub.tutorial.springboot.ms.item.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class Controller {

    @GetMapping("/items")
    public ItemListResponse items() {
        log.info("Items orders...");

        List<ItemResponse> items = new ArrayList<>();

        items.add(ItemResponse.builder().id("100001").name("Item 1").build());
        items.add(ItemResponse.builder().id("100002").name("Item 2").build());

        log.info("Loaded items {}", items.size());

        return ItemListResponse.builder().items(items).build();
    }

}
