import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /*

     */
    //测试查询
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory,构建者设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AdminDao adminDao = session.getMapper(AdminDao.class);
        //查询所有数据
        List<Admin> list = adminDao.findAll();
        for(Admin admin:list){
            System.out.println(admin);
        }
        //关闭资源
        session.close();
        in.close();
    }

    //测试插入数据保存
    @Test
    public void run2() throws IOException {
        Admin admin = new Admin();
        admin.setUsername("henry");
        admin.setPassword("henry123");

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory,构建者设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AdminDao adminDao = session.getMapper(AdminDao.class);

        //插入数据
        adminDao.saveAdmin(admin);

        //提交事务
        session.commit();

        //关闭资源
        session.close();
        in.close();
    }


}
