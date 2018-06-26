package simplecrm.service.impl;


import com.aoao.simpleCrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simplecrm.dao.IUserDao;
import simplecrm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iud;

    @Override
    public Employee loginByUsernameAndPassword(String username, String password) {
        return iud.loginByUsernameAndPassword(username,password);
    }
}
