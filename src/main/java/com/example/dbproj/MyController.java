package com.example.dbproj;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyController {
    MyService myService;

    @GetMapping(name = "/hello")
    public String hello() {
        System.out.println(myService.getChildren());
        return "";
    }
}
