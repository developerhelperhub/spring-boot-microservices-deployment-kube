package com.developerhelperhub.tutorial.springboot.ms.order.service;

import lombok.Setter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class StartupHealthIndicator implements HealthIndicator {

    @Setter
    private boolean startupComplete = false;

    @Override
    public Health health() {
        if (this.startupComplete) {
            return Health.up().withDetail("startup", "Complete").build();
        } else {
            return Health.down().withDetail("startup", "In Progress").build();
        }
    }
}
