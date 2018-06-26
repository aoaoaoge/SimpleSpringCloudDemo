package simpleCrm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableEurekaClient     //注册到eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //熔断机制
@EnableZuulProxy        //网关
public class Simplecrm_gateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(Simplecrm_gateway9527.class, args);
    }
}
