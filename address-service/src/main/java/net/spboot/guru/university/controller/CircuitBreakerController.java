package net.spboot.guru.university.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
    
   private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/testapi")
    // retry
    @Retry(name="test-api", fallbackMethod = "headcodedResponse")
    public String testApi() {
        logger.info("Test Api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8986/some-dummy-url", String.class);
        return forEntity.getBody();
    }
    
    public String headcodedResponse(Exception exception) {
        return "fallback-response";
        
    }

}
