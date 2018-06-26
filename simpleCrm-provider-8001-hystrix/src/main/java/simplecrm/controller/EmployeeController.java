package simplecrm.controller;


import com.aoao.simpleCrm.entities.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import simplecrm.service.IEmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService ies;
    @Autowired
    private DiscoveryClient discoveryClient;

    /*@RequestMapping(value = "/emp/{emp_id}", method = RequestMethod.GET)
    public ModelAndView queryEmployeeById(@PathVariable("emp_id") Integer emp_id, ModelAndView mav){
        Employee emp = ies.queryEmployeeById(emp_id);
        mav.addObject("user",emp);
        mav.setViewName("thymeleaf-test");
        return mav;
    }*/

    @RequestMapping(value = "/emp/{emp_id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Employee queryEmployeeById(@PathVariable("emp_id") Integer emp_id){
        Employee emp = ies.queryEmployeeById(emp_id);
        if (emp == null){
            throw new RuntimeException("此ID的员工信息为空！");
        }
        return emp;
    }
    public Employee processHystrix_Get(@PathVariable("emp_id") Integer emp_id){
        return new Employee().setEmp_id(emp_id).setEmp_name("此员工ID:"+emp_id+"没有信息");
    }

    @GetMapping(value = "/emp/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("########"+list);
        List<ServiceInstance>  serviceInstanceList = discoveryClient.getInstances("microservice-crm");
        for(ServiceInstance sil:serviceInstanceList){
            System.out.println(sil.getServiceId()+"\t"+sil.getHost()+"\t"+sil.getPort()+"\t"+sil.getUri());
        }
        return this.discoveryClient;
    }
}
