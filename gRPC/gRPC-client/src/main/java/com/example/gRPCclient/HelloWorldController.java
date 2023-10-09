package com.example.gRPCclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable String name) {
        String response = helloWorldClient.sayHello("John");
//        return ResponseEntity.ok(response);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/badSayHello/{name}")
    public String badSayHello(@PathVariable String name) {
        String response = helloWorldClient.sayHello("John");
//        return ResponseEntity.ok(response);
        ResponseEntity.badRequest();
        return "vse ochem huevo";
    }
}
