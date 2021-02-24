package com.example.gateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    // ApplicationContext, um später den Microservice herunterzufahren
    @Autowired
   private ApplicationContext appContext;

    // Über die URL wird der Microservice beendet
    @GetMapping(path="/shutdown")
    public void shutdown(){
        SpringApplication.exit(appContext, () -> 0);
    }
}
