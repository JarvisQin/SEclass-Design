package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.dao.StudentDao;
import ssm.service.ClassService;
import ssm.util.ResultUtil;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/classList")
    public String studentList()
    {
        return "/jsp/class/classList";
    }

    @RequestMapping("/getClassList")
    @ResponseBody
    public ResultUtil getClassList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return classService.getClassList(page,limit);
    }

    @RequestMapping("/delClass/{classId}")
    @ResponseBody
    public ResultUtil deleteClass(@PathVariable("classId")int classId){
        List<Student> studentList=studentDao.getStudentByClassId(classId);
        if(studentList.size()!=0){
            return ResultUtil.error();
        }
        else {
            classService.deleteByClassId(classId);
            return ResultUtil.ok();
        }

    }
    @RequestMapping("/editClass/{classId}")
    public String editClass(@PathVariable("classId")int classId, HttpSession session)
    {
        DClass dClass=classService.getClassById(classId);
        session.setAttribute("dClass",dClass);
        return "/jsp/class/editClass";
    }

    @RequestMapping("/checkClassName/{className}")
    @ResponseBody
    public ResultUtil checkClassName(@PathVariable("className")String className)
    {
        DClass dClass=classService.getClassByClassName(className);
        if(dClass!=null)
        {
            return new ResultUtil(500,"班级名称已经存在，请做标记");
        }
        return new ResultUtil(0);
    }

    @RequestMapping("/updClass")
    @ResponseBody
    public ResultUtil updateClass(DClass dclass)throws ParseException
    {
        return classService.updateClass(dclass);
    }
    @RequestMapping("/addClass")
    public String addClass()
    {
        return "/jsp/class/addClass";
    }

    @RequestMapping("/insClass")
    @ResponseBody
    public ResultUtil addClass(DClass dclass)
    {
        try {
            classService.addClass(dclass);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

}
