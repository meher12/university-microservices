package net.spboot.guru.university.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {
    
   private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/testapi")
    //@Retry(name="test-api", fallbackMethod = "headcodedResponse")
    //@CircuitBreaker(name="default", fallbackMethod = "headcodedResponse")
    //@RateLimiter(name="default", fallbackMethod = "headcodedResponse")
    @Bulkhead(name="default")
    public String testApi() {
        logger.info("Test Api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8986/some-dummy-url", String.class);
//        return forEntity.getBody();
        return "Test Api";
    }
    
    public String headcodedResponse(Exception exception) {
        return "fallback-response";
        
    }

}
