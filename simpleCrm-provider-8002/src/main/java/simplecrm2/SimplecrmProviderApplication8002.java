package simplecrm2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan(value = "simplecrm2.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SimplecrmProviderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(SimplecrmProviderApplication8002.class, args);
    }
}
