package net.spboot.guru.university.logger;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Path of the request received -> {}", exchange.getRequest().getPath());
        log.info("Logging PRE Filter Start: request id -> {}", exchange.getRequest().getId());
        log.info("Logging POST Filter End: response code -> {}", exchange.getResponse().getStatusCode());
        
        return chain.filter(exchange);
    }
    
   
  
}
