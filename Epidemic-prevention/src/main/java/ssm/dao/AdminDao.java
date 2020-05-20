package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdminDao {
    //AdminLog
    void addAdminLog(@Param("adminUsername") String username, @Param("loginIp") String loginIp,
                     @Param("loginTime") Date loginTime, @Param("logoutTime") Date logoutTime,
                     @Param("isSafeExit") Integer isSafeExit);
    AdminLog getAdminLogByLoginTime(Date loginTime);
 //   AdminLog getAdminlogByUsername();
 //   AdminLog getAdminLogByLoginTime();
    void updateAdminLog(AdminLog adminLog);
    List<AdminLog> getAdminLogList();

    //Admin
    Admin login(@Param("username") String username, @Param("password") String password);
    Admin getAdminById(Integer adminId);
    List<Admin> getAdminByRoleId(int roleId);
    void updateAdmin(Admin admin);
    Admin getAdminByUsername(String username);
    //都可用
    List<Admin> getAdminList();
    @Select("select * from admin")    public List<Admin> findAll();
    void addAdmin(Admin admin);
    @Insert("insert into admin(username,password) values (#{username},#{password})")    public void saveAdmin(Admin admin);
    void deleteAdminById(Long adminId);
}
