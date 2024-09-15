package com.developerhelperhub.tutorial.springboot.ms.item.service;

import lombok.Builder;

import java.util.List;


public record ItemListResponse(List<ItemResponse> items) {
    @Builder
    public ItemListResponse {}
}
