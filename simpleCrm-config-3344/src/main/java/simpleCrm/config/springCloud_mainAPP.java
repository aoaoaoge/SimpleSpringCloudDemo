package simpleCrm.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class springCloud_mainAPP {
    public static void main(String[] args){
        SpringApplication.run(springCloud_mainAPP.class,args);
    }
}
