package com.example.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileSystems;

@RestController
public class BasicServiceController {



    @GetMapping(path="/greeting")
    public String showResponse(){
     return "Hello from the Fabric!";
    }

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
