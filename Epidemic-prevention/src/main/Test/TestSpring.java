import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.service.AdminService;
import ssm.service.DormitoryService;

public class TestSpring {
    @Test
    public void run(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AdminService adminService = (AdminService) ac.getBean("adminService");
        //调用方法
        adminService.findAll();
    }

}
