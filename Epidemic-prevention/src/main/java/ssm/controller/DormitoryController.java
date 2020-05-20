package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ssm.dao.StudentDao;
import ssm.service.DormitoryService;
import ssm.util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentDao studentDao;



    private String dirPath = "D:/uploadDormitory/";
    //这里我们没有在tomcat中配置虚拟路径 而是在IDEA 中配置虚拟路径 方法看保存截图 如何在IDEA中
    // 配置虚拟路径 注意前端加载预览图片url
    // 是http://localhost:8080/ssm_houseRent_layui/file/16162dfe-119f-4559-b994-54faece227b0.gif
    //所以配置的虚拟路径不能是/file而是/ssm_houseRent_layui/file
    //file 是 singleUpload这个函数中加上的 也可以改成别的

    // 简介图片地址
    private String simplePath = "";
    // 详细图片地址
    private StringBuilder detailsPath = new StringBuilder();



    //上传多个图片

    @RequestMapping("/MultipleUpload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") List<MultipartFile> file,
                                      HttpServletRequest req) {
        Map<String, Object> map = new HashMap<String,Object>();
        if (!file.isEmpty() && file.size() > 0) {
            for (MultipartFile f : file) {
                try {
                    // 文件名
                    String filename = UUID.randomUUID()
                            + f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
                    // 存储虚拟路径
                    String localPath = req.getServletContext().getContextPath() + "/file/" + filename;
                    //多个图片之间存放在数据库中的时候 用 ~ 分隔起来
                    detailsPath.append(localPath+"~");

                    File filePath = new File(dirPath);
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    //上传
                    f.transferTo(new File(dirPath + filename));

                } catch (Exception e) {
                    map.put("code", 1);
                    map.put("msg", "上传失败");
                    e.printStackTrace();
                }
            }
            map.put("code", 0);
            map.put("msg", "上传成功");
        }
        return map;
    }


    //上传单个文件
    @RequestMapping("/singleUpload")
    @ResponseBody
    public Map<String, Object> singleUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req,
                                            HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filename = UUID.randomUUID() + suffixName;
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            //创建虚拟路径存储
            simplePath = req.getServletContext().getContextPath() + "/file/" + filename;
           // simplePath = filename;
            map.put("image", simplePath);
            file.transferTo(new File(dirPath + filename));
            map.put("code", 0);
            map.put("msg", "上传成功");
        } catch (Exception e) {
            map.put("code", 1);
            map.put("msg", "上传失败");
            e.printStackTrace();
        }
        return map;
    }





    @RequestMapping("/dormitoryList")
    public String dormitoryList()
    {
        return "/jsp/dormitory/dormitoryList";
    }
    @RequestMapping("/getDormitoryList")
    @ResponseBody
    public ResultUtil getDormitoryList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return dormitoryService.getDormitoryList(page,limit);
    }

    //检查是否存在同名宿舍
    @RequestMapping("/checkDormitoryNumber/{dormitoryNumber}")
    @ResponseBody
    public ResultUtil checkDormitoryNumber(@PathVariable("dormitoryNumber")String dormitoryNumber)
    {
        Dormitory dormitory=dormitoryService.checkDormitoryNumber(dormitoryNumber);
        if(dormitory!=null)
        {
            return new ResultUtil(500,"宿舍名称已经存在，请做标记");
        }
        return new ResultUtil(0);
    }

    @RequestMapping("/addDormitory")
    public String addDormitory()
    {
        return "/jsp/dormitory/addDormitroy";
    }

    @RequestMapping("/insertDormitory")
    @ResponseBody
    public ResultUtil insertDormitory(Dormitory dormitory)
    {

        dormitory.setDormitoryPhoto(simplePath); //图片路径保存一下
        dormitory.setDormitoryPhotoDetail(detailsPath.toString());
        //     System.out.println(aclass);
        try {
            dormitoryService.addDormitory(dormitory);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    //查看宿舍详情
    @RequestMapping("/detailDormitory/{dormitoryId}")

    public String detailDormitory(@PathVariable("dormitoryId")int dormitoryId, HttpSession session)
    {
        Dormitory dormitory=dormitoryService.getDormitoryById(dormitoryId);
        List<String> list = new ArrayList<String>();
        String[] split = dormitory.getDormitoryPhotoDetail().split("~");
        for(int i=0;i<split.length;i++) {
            list.add(split[i]);
        }

       // session.setAttribute("dormitory",dormitory);
        session.setAttribute("DetailsImg", list);
        return "/jsp/dormitory/dormitoryDetail";
    }

    //删除宿舍
    @RequestMapping("/deleteDormitory/{dormitoryId}")
    @ResponseBody
    public ResultUtil deleteDormitory(@PathVariable("dormitoryId")int dormitoryId){
        List<Student> studentList=studentDao.getStudentByDormitoryId(dormitoryId);
        if(studentList.size()!=0){ //说明此班级下有学生 不能删除
            return ResultUtil.error();
        }
        else {
            dormitoryService.deleteByDormitoryId(dormitoryId);
            return ResultUtil.ok();
        }

    }



}
