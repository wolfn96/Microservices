package com.example.factory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileSystems;

@RestController
public class BasicServiceController {

    // Applikationskontext, um den Microservice später zu beenden
    @Autowired
    private ApplicationContext appContext;

    // Über den Aufruf der URL gibt die Fabrik einen Gruß zurück
    @GetMapping(path="/greeting")
    public String showResponse(){
     return "Hello from the Fabric!";
    }

    // Über die URL wird der Microservice beendet
    @GetMapping(path="/shutdown")
    public void shutdown(){
        SpringApplication.exit(appContext, () -> 0);
    }

    // über diese URL kann ein Serivce über die Kommandozeile gestartet werden
    @GetMapping(path="/startService")
    public String startClient(){
        try{
            Runtime.getRuntime().exec("java -jar \"/Service/build/libs/service-0.0.1-SNAPSHOT.jar\" > /dev/null 2>&1 &");
         }catch(Exception e){
            e.printStackTrace();
            return "Es ist ein Fehler aufgetreten";
         }

        return "Es wurde ein neuer Service gestartet";
    }
}
