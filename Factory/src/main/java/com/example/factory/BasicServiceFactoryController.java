package com.example.factory;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;
import java.io.Console;

@RestController
public class BasicServiceFactoryController {


    private BasicService firstService;
    private BasicService secondService;
    private BasicService thirdService;

    @GetMapping(path="/addBasicService")
    public String greeting(@RequestParam(name="name",defaultValue="User")String name){
      BasicServiceFactory factory = new BasicServiceFactory();
      int counter = 0;

      try {
          BasicService service = factory.getObject();
          counter = service.getId();

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
