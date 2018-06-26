package simplecrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@MapperScan(value = "simplecrm.dao")
@SpringBootApplication
@EnableEurekaClient     //注册到eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //熔断机制
public class SimplecrmProviderApplication8001Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(SimplecrmProviderApplication8001Hystrix.class, args);
    }
}
