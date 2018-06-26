package simpleCrm.consumer;


import myIRule.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-CRM",configuration = MyIRule.class)
public class crm_consumer_main {
    public static void main(String[] args) {
        SpringApplication.run(crm_consumer_main.class, args);
    }
}
