package org.polytech.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

    @GetMapping ("/hello")
    public Patient hello(){
        return new Patient(0, "John");
    }

}
