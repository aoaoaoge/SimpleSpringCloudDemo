package com.aoao.simpleCrm.service;


import com.aoao.simpleCrm.entities.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "MICROSERVICE-CRM",fallbackFactory = CrmClientServiceFallbackFactory.class)
public interface EmployeeClientService {

    @RequestMapping(value = "/emp/{emp_id}",method = RequestMethod.GET)
    public Employee queryEmployeeById(@PathVariable("emp_id") Integer emp_id);

    @PostMapping(value = "/emp/showAllemp.do")
    public Map<String, Object> showEmployee(int page, int rows);

    @GetMapping(value = "/emp/discovery")
    public Object discovery();
}
