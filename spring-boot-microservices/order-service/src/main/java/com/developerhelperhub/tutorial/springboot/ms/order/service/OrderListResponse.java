package com.developerhelperhub.tutorial.springboot.ms.order.service;

import lombok.Builder;

import java.util.List;


public record OrderListResponse(List<OrderResponse> items) {
    @Builder
    public OrderListResponse {}
}
