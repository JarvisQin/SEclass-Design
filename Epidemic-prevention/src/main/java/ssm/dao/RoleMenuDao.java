package ssm.dao;


import java.util.List;

public interface RoleMenuDao {
    List<RoleMenu> getMenusByRoleId(Long roleId);
    void deleteMenusByRoleId(Long roleId);
    void addRoleMenu(RoleMenu roleMenu);
}
