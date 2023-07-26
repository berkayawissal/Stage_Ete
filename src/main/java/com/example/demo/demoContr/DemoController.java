package com.example.demo.demoContr;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/hello")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> hello(){
        return  ResponseEntity.ok("connected");
    }
}
