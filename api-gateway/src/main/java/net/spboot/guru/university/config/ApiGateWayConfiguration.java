package net.spboot.guru.university.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class ApiGateWayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/api/v1/students/**").uri("lb://student-service/"))
                .route(p -> p.path("/api/address/**").uri("lb://address-service/"))
                .route(p -> p.path("/student/**")
                        .filters(f -> f.rewritePath("/student/(?<segment>.*)", "/api/v1/students/${segment}"))
                        .uri("lb://student-service/"))
                .build();
        
        // p -> p.path("/api/v1/students/**" : Path to RestAPI).uri("lb://student-service/": name of service)
        
        // To create a specific filter path :
        /*
        .route(p -> p.path("/student/**")
        // this url student/(?<segment>.*) sreplace  /api/v1/students/${segment}
                .filters(f -> f.rewritePath("/student/(?<segment>.*)", "/api/v1/students/${segment}"))
                .uri("lb://student-service/"))
         */

    }
}
