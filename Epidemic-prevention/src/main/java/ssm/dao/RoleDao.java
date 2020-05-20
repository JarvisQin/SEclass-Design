package ssm.dao;

import java.util.List;

public interface RoleDao {
    void updateByKey(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
    void deleteRole(Long roleId);
    Role getRoleByRoleName(String roleName);
    void addRole(Role role);
//    Role selectRoleByRoleName(String roleName);
}
