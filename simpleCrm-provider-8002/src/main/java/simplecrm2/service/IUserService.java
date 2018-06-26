package simplecrm2.service;

import com.aoao.simpleCrm.entities.Employee;

public interface IUserService {
    Employee loginByUsernameAndPassword(String username, String password);
}
