package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.User;

public interface UserDao {
    User login(@Param("username") String username
            ,@Param("password") String password);
    User getInfoByUsername(String username);
    void addUser(User user);

}
