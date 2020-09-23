package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    
    @Autowired
    MessageRepository messageRepository;
    
    @Value("${app.default.language}")
    private String language;
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        long incrementAndGet = counter.incrementAndGet();
        logger.info("greeting message log N°: " +incrementAndGet);
        Message message = messageRepository.findByLang(language);
        return new Greeting(incrementAndGet, message.getMsg());
    }

    @GetMapping("/greeting/lang/{lang}")
    public Greeting greetingLang(@RequestParam(value = "name") String name) {
        long incrementAndGet = counter.incrementAndGet();
        logger.info("greeting message log N°: " +incrementAndGet);
        Message message = messageRepository.findByLang(name);
        return new Greeting(incrementAndGet, message.getMsg());
    }
    
//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//            return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}
