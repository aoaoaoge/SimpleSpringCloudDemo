package simpleCrmFeign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.aoao.simpleCrm"})
@ComponentScan("com.aoao.simpleCrm")
public class crm_consumer_feign_main {
    public static void main(String[] args) {
        SpringApplication.run(crm_consumer_feign_main.class, args);
    }
}
