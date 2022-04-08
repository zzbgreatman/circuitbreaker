package com.example.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public class HystrixFallbackRestController {
    @GetMapping("/cc-converter/fallback")
    public Mono<String> getCcSvcMsg() {
        return Mono.just("No response fron Currency Conversion Service and will be back shortly");
    }
}
