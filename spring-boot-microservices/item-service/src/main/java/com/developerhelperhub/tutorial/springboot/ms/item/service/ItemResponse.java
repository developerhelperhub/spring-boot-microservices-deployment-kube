package com.developerhelperhub.tutorial.springboot.ms.item.service;

import lombok.Builder;

public record ItemResponse(String id, String name) {

    @Builder
    public ItemResponse {}
}
