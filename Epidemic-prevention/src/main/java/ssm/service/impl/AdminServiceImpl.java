package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.AdminDao;
import ssm.dao.MenuDao;
import ssm.dao.RoleDao;
import ssm.dao.RoleMenuDao;
import ssm.domain.*;
import ssm.service.AdminService;
import ssm.util.EncryptUtil;
import ssm.util.ResultUtil;

import java.text.ParseException;
import java.util.*;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        System.out.println("业务层admin:查询所有用户");
        return adminDao.findAll();

    }

    @Override
    public void saveAdmin(Admin admin) {
        System.out.println("业务层save admin");
        adminDao.saveAdmin(admin);

    }


    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username,password);
    }

    @Override
    public void addAdminLog(String username, String loginIp, Date loginTime, Date logoutTime, Integer isSafeExit) {
        adminDao.addAdminLog(username,loginIp,loginTime,logoutTime,isSafeExit);
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminDao.getAdminById(adminId);
    }

    @Override
    public List<Menu> getMenus(Admin admin) {
        List<Menu> menuList=new ArrayList<>();
        Long roleId=admin.getRoleId();
        List<RoleMenu> roleMenus=roleMenuDao.getMenusByRoleId(roleId);

        if(roleMenus!=null&&roleMenus.size()>0)
        {
            List<Menu> noChildrenMenus=new ArrayList<>();
            for(int i=0;i<roleMenus.size();i++)
            {
                Menu menu=menuDao.getMenuById(roleMenus.get(i).getMenuId());
                noChildrenMenus.add(menu);
            }
            for(int i=0;i<noChildrenMenus.size();i++)
            {
                if(noChildrenMenus.get(i).getParentId()==0)
                {
                    Menu menu=new Menu();
                    menu=noChildrenMenus.get(i);
                    List<Menu> menus=new ArrayList<>();
                    for(int j=0;j<noChildrenMenus.size();j++)
                    {
                        if(noChildrenMenus.get(j).getParentId()==noChildrenMenus.get(i).getMenuId())
                        {
                            Menu menu2=new Menu();
                            menu2=noChildrenMenus.get(j);
                            menus.add(menu2);
                        }
                    }
                    menu.setChildren(menus);
                    menuList.add(menu);
                }
            }

        }

        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {

                return o1.getSorting().compareTo(o2.getSorting());
            }
        });

        return menuList;
    }

    @Override
    public AdminLog getAdminLogByLoginTime(Date loginTime) {
        return adminDao.getAdminLogByLoginTime(loginTime);
    }

    @Override
    public void updateAdminLog(AdminLog adminLog) {
        adminDao.updateAdminLog(adminLog);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.getAdminByUsername(username);
    }

    @Override
    public ResultUtil getAdminLogList(Integer page, Integer limit) throws ParseException {
        List<AdminLog> adminLogList=new ArrayList<>();

        //带分页的查询 sql server 中 select 语句必须有 order by
        PageHelper.startPage(page,limit);
        List<AdminLog> adminLogs=adminDao.getAdminLogList();
        PageInfo<AdminLog> pageInfo=new PageInfo<>(adminLogs);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal()-1); //不显示最后一条数据
        //不显示最后一条登陆信息 因为是正在登陆
        adminLogList.addAll(pageInfo.getList().subList(0,pageInfo.getList().size()-1));

        resultUtil.setData(adminLogList);
        return resultUtil;
    }

    @Override
    public ResultUtil getAdminList(Integer page, Integer limit)
    {
        PageHelper.startPage(page,limit); //默认传过来的是1 和10

        List<Admin> admins=adminDao.getAdminList();


        for(Admin admin:admins)
        {
            List<Role> roles=roleDao.getAllRoles();//取出所有的角色
            for(Role role:roles)
            {
                if(role.getRoleId()==admin.getRoleId())
                {
                    admin.setRoleName(role.getRoleName());
                    System.out.println(admin.toString());
                }
            }
        }

        PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);//前段接收为0 代表成功
        resultUtil.setCount(pageInfo.getTotal());//代表数据库中总条数
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addAdmin(Admin admin) {
        admin.setPassword(EncryptUtil.encrypt(admin.getPassword()));//加密
        adminDao.addAdmin(admin);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleDao.getRoleById(roleId);
    }



    @Override
    public void deleteAdminById(Long adminId) {
        adminDao.deleteAdminById(adminId);
    }

    @Override
    public ResultUtil getRoles(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Role> roles=roleDao.getAllRoles();
        PageInfo<Role> pageInfo=new PageInfo<Role>(roles);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Menu> getXtreeData(Long roleId) {
        List<Menu> allMenus=menuDao.getAllMenus(); //获得所有的菜单
        if(!roleId.equals(Long.valueOf("-1")))//不是-1
        {
            List<RoleMenu> roleMenus=roleMenuDao.getMenusByRoleId(roleId); //选出此角色对应的菜单
            for(Menu menu:allMenus) //遍历所有菜单
            {
                for(RoleMenu roleMenu:roleMenus)
                {
                    if(roleMenu.getMenuId()==menu.getMenuId())
                    {
                        menu.setChecked("true"); //将所有菜单中 此角色有的菜单


                    }
                }

            }

        }
        return allMenus;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleDao.getRoleByRoleName(roleName);
    }

    @Override
    public void updateRole(Role role, String m) {
        roleDao.updateByKey(role);
        roleMenuDao.deleteMenusByRoleId(role.getRoleId()); //把roleId对应的原来的菜单都删除
        // 维护角色-菜单表 m中就是 1,2,3,4,5 这种格式
        if(m!=null&&m.length()!=0)
        {
            String [] result=m.split(",");
            //重新赋予权限
            if(result!=null&&result.length>0)
            {
                for(int i=0;i<result.length;i++)
                {
                    RoleMenu roleMenu=new RoleMenu();
                    roleMenu.setMenuId(Long.parseLong(result[i]));
                    roleMenu.setRoleId(role.getRoleId());
                    //插入一条数据
                    roleMenuDao.addRoleMenu(roleMenu);
                }
            }
        }
    }

    @Override
    public void addRole(Role role, String m) {
        roleDao.addRole(role); //插入一条新数据
        Role role2=roleDao.getRoleByRoleName(role.getRoleName()); //把新插入的读出来
        if(m!=null&&m.length()!=0)
        {
            String [] result=m.split(",");
            if(result!=null&&result.length>0)
            {
                for(int i=0;i<result.length;i++)
                {
                    RoleMenu roleMenu=new RoleMenu();
                    roleMenu.setMenuId(Long.parseLong(result[i]));
                    roleMenu.setRoleId(role2.getRoleId());
                    roleMenuDao.addRoleMenu(roleMenu);
                }
            }
        }

    }

}
