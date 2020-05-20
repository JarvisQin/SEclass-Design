package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dao.AdminDao;
import ssm.dao.DormitoryDao;
import ssm.service.FixService;
import ssm.util.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/fix")
public class FixController {

    @Autowired
    private FixService fixService;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private DormitoryDao dormitoryDao;

    @RequestMapping("/fixList")
    public String fixList()
    {

        return "/jsp/fix/fixList";
    }
    @RequestMapping("/getFixList")
    @ResponseBody
    public ResultUtil getFixList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return fixService.getFixList(page,limit);
    }

    @RequestMapping("/addFix")
    public String addFix(HttpSession session)
    {

        List<Admin> fixPeoples=adminDao.getAdminByRoleId(4); //4表示 角色是维修人员

        List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
        session.setAttribute("fixPeoples",fixPeoples);
        session.setAttribute("dormitories",dormitories);
        return "/jsp/fix/addFix";
    }

    @RequestMapping("/insertFix")
    @ResponseBody
    public ResultUtil addFix(Fix fix)
    {

        try {
            fixService.addFix(fix);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    @RequestMapping("/editFix/{id}")
    public String editFix(@PathVariable("id")int id, HttpSession session)
    {
        Fix  fix1=fixService.getFixById(id);
        List<Admin> fixPeoples=adminDao.getAdminByRoleId(4); //4表示 角色是维修人员
        List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
        session.setAttribute("fixPeoples",fixPeoples);
        session.setAttribute("dormitories",dormitories);
        session.setAttribute("fix1",fix1);
        return "/jsp/fix/editFix";
    }

    @RequestMapping("/updateFix")
    @ResponseBody
    public ResultUtil updateFix(Fix fix){
        System.out.println(fix);
        try {
            fixService.updateFix(fix);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    @RequestMapping("/delFix/{id}")
    @ResponseBody
    public ResultUtil delFix(@PathVariable("id")int fixId){
        fixService.deleteFixById(fixId);
        return ResultUtil.ok();
    }

}
