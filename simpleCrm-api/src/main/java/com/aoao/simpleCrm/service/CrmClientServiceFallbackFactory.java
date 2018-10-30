package com.aoao.simpleCrm.service;

import com.aoao.simpleCrm.entities.Employee;
import feign.hystrix.FallbackFactory;

import java.util.Map;

public class CrmClientServiceFallbackFactory implements FallbackFactory<EmployeeClientService> {

    @Override
    public EmployeeClientService create(Throwable throwable) {
        return new EmployeeClientService() {
            @Override
            public Employee queryEmployeeById(Integer emp_id) {
                Employee employee = new Employee();
                employee.setEmp_id(emp_id);
                employee.setEmp_name("该ID"+emp_id+"没有对应信息，此服务已降级");
                return employee;
            }

            @Override
            public Map<String, Object> showEmployee(int page, int rows) {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
