package simpleCrm.consumer.controller;

import com.aoao.simpleCrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class employeeController_consumer {

    //private final String REST_URL_PREFIX="http://localhost:8001";
    private final String REST_URL_PREFIX="http://MICROSERVICE-CRM";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/emp/{emp_id}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/emp/"+emp_id,Employee.class);
    }

    // 消费者调用服务发现
    @RequestMapping(value = "/consumer/emp/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/emp/discovery",Object.class);
    }
}
