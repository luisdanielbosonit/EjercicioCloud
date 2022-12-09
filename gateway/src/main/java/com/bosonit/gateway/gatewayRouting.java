package com.bosonit.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class gatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cliente", r->r.path("/cliente/**").uri("http://localhost:8088/cliente"))
                .route("viajes", r->r.path("/viajes/**").uri("http://localhost:8088/viajes"))
                .route("ticket", r->r.path("/ticket/**").uri("http://localhost:8089/ticket"))
                .build();
    }
}
