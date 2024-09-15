package com.developerhelperhub.tutorial.springboot.ms.order.service;

import lombok.Builder;

public record OrderResponse(String id, String date) {

    @Builder
    public OrderResponse {}
}
