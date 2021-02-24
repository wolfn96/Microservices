package com.example.factory.Controller;

import com.example.factory.Service.BasicService;
import com.example.factory.Service.BasicServiceFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicServiceFactoryController {

    // Es wird ein DiscoveryClient für Eureka angelegt
    @Autowired
    private DiscoveryClient discoveryClient;

    // Es gibt 3 statische Variablen für die Services innerhalb der Fabrik-Instanz hinzugefügt werden können
    private static BasicService firstService;
    private static BasicService secondService;
    private static BasicService thirdService;


    // Über diese URL kann, wenn weniger als 3 interne Service-Instanzen aktiv sind ein weitere Service hinzugefügt werden
    @GetMapping(path="/act")
    public String showResponse(@RequestParam(name="name",defaultValue="User")String name){

        // Erstellt eine neue Instanz der lokalen Fabrik und resetet den Counter
      BasicServiceFactory factory = new BasicServiceFactory();
      int counter = 0;

      try {
          BasicService service = factory.getObject();
          counter = service.getId();

          // Fragt ob, ob weniger als 3 interne Services aktiv sind
          switch (counter){
              case 1:
                  firstService = service;
                  break;
              case 2:
                  secondService = service;
                  break;
              case 3:
                  thirdService = service;
                  break;
              default:
                  counter = 3;
                  return "Es wurden bereits 3 Services erstellt und deswegen kann leider kein neuer hinzugefügt werden";

          }

      }catch(Exception e){
          e.printStackTrace();
      }

     return "Service mit Id "+counter+" wurde erstellt";
    }





}
