package simpleCrmFeign.controller;


import com.aoao.simpleCrm.entities.Employee;
import com.aoao.simpleCrm.service.EmployeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class employee_feign_Controller_consumer {

    @Autowired
    public EmployeeClientService ecs;

    @GetMapping(value = "/consumer/emp/{emp_id}")
    public Employee queryEmpById(@PathVariable("emp_id") Integer emp_id){
        return  this.ecs.queryEmployeeById(emp_id);
    }

}
