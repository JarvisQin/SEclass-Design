package ssm.dao;


import java.util.List;

public interface MenuDao {
//    void updateMenuByKey(Menu menu);
    Menu getMenuById(Long menuId);
    List<Menu> getAllMenus();

}
