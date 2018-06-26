package simplecrm2.controller;


import com.aoao.simpleCrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import simplecrm2.service.IEmployeeService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Employee queryEmployeeById(@PathVariable("emp_id") Integer emp_id){
        Employee emp = ies.queryEmployeeById(emp_id);
        return emp;
    }

    @PostMapping(value = "/emp/showAllemp.do")
    protected Map<String, Object> showEmployee(int page, int rows){
        //获取到分页数据
        List<Employee> list = ies.selectAllEmployee(page,rows);
        Map<String, Object> map = new HashMap<String, Object>();
        int count = ies.countEmployees();
        map.put("total", count);
        map.put("rows", list);
        return map;

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
