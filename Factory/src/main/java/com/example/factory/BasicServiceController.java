package com.example.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicServiceController {

    BasicService service;

    @GetMapping(path="/greeting")
    public String greeting(){
     return service.getName();
    }
}
