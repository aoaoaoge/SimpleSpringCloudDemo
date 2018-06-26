package simplecrm2.service;


import com.aoao.simpleCrm.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee queryEmployeeById(Integer emp_id);
    int insertEmployee(Employee emp);
    List<Employee> selectAllEmployee(int pageNum, int pageSize);
    int countEmployees();
}
