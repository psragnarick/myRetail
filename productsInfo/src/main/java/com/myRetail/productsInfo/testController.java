package com.myRetail.productsInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class testController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public test test(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new test(counter.incrementAndGet(), String.format(template, name));
    }
}
