package simplecrm.service.impl;


import com.aoao.simpleCrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simplecrm.dao.IEmployeeDao;
import simplecrm.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeDao ied;

    @Transactional(readOnly=true)
    public Employee queryEmployeeById(Integer emp_id) {
        return ied.queryEmployeeById(emp_id);
    }

    @Override
    public int insertEmployee(Employee emp) {
        return ied.insertEmployee(emp);
    }

    @Transactional(readOnly=true)
    public List<Employee> selectAllEmployee(int pageNum, int pageSize) {
        pageNum = (pageNum-1)*pageSize;
        List<Employee> list = ied.selectAllEmployee(pageNum,pageSize);
        return list;
    }
    @Transactional(readOnly=true)
    public int countEmployees() {
        return ied.countEmployees();
    }
}
