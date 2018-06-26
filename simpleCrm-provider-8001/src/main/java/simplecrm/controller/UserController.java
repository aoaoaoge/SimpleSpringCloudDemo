package simplecrm.controller;


import com.aoao.simpleCrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import simplecrm.service.IUserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    IUserService ius;
    @PostMapping(value = "/user/login.do")
    public ModelAndView userLogin(ModelAndView mav, String username, String password, HttpServletRequest req){
        Employee emp = ius.loginByUsernameAndPassword(username,password);
        if (emp == null){
            mav.addObject("error","帐号或密码错误请重试！");
            mav.setViewName("userlogin");
        }
        else {
            mav.addObject("user", emp);
            mav.setViewName("thymeleaf-test");
            req.setAttribute("user",emp);
        }
        return mav;
    }
}
