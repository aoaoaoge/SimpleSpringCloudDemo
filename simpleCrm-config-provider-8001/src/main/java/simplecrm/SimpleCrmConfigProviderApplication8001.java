package simplecrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan(value = "simplecrm.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SimpleCrmConfigProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrmConfigProviderApplication8001.class, args);
    }
}
