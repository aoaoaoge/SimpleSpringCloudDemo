package simplecrm2.dao;

import com.aoao.simpleCrm.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserDao {
    Employee loginByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
