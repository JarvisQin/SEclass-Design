package ssm.service;

import ssm.util.ResultUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface AdminService {

   //Log
    void addAdminLog(String username, String loginIp, Date loginTime, Date logoutTime, Integer isSafeExit);
    AdminLog getAdminLogByLoginTime(Date loginTime);
    void updateAdminLog(AdminLog adminLog);
    ResultUtil getAdminLogList(Integer page, Integer limit) throws ParseException;


    //Admin
    //登陆
    Admin login(String username, String encrypt);
    Admin getAdminById(Integer adminId);
    Role getRoleById(Long roleId);
    void updateAdmin(Admin admin);
    Admin getAdminByUsername(String username);
    ResultUtil getAdminList(Integer page, Integer limit);
    void addAdmin(Admin admin);
    void deleteAdminById(Long adminId);

    public List<Admin> findAll();
    public void saveAdmin(Admin admin);

    //Menu
    List<Menu> getMenus(Admin admin);

    //role
   //得到所有角色
    List<Role> getRoles();
    ResultUtil getRoles(Integer page, Integer limit);

    void deleteRole(Long roleId);
    Role getRoleByRoleName(String roleName);
    void updateRole(Role role, String m);
    void addRole(Role role, String m);
    //选出管理员拥有的所有菜单
    List<Menu> getXtreeData(Long roleId);
}
