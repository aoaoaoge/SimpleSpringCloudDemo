package simplecrm.dao;


import com.aoao.simpleCrm.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IEmployeeDao {

    //1、注解方式  2、映射配置文件方式
    //@Select("select * from t_dams_employee where emp_id = #{emp_id}")
    Employee queryEmployeeById(Integer emp_id);

    //@Options(useGeneratedKeys = true,keyProperty = "emp_id")
    //@Insert("insert into t_dams_employee(role_id,emp_name,emp_loginname,emp_password,emp_gender,emp_telphone,emp_email,emp_address,emp_birthday,create_time) value(#{role_id},#{emp_name},#{emp_loginname},#{emp_password},#{emp_gender},#{emp_telphone},#{emp_email},#{emp_address},#{emp_birthday},#{create_time})")

    int insertEmployee(Employee emp);

    List<Employee> selectAllEmployee(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    int countEmployees();
}
