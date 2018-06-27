package simpleCrm.client.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class configClientRest {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String showConfig(){
        System.out.println("------------>applicationName:"+applicationName+" eurekaServers:"+eurekaServers+" port:"+port);
        return "applicationName:"+applicationName+"\t eurekaServers:"+eurekaServers+"\t port:"+port;
    }
}
