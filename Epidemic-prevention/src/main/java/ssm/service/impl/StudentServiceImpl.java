package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.StudentDao;
import ssm.service.StudentService;
import ssm.util.ResultUtil;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search) {
        PageHelper.startPage(page,limit);
        List<Student> students=studentDao.getAllStudentList(search);
        PageInfo<Student> pageInfo=new PageInfo<>(students);
     //   System.out.println(pageInfo.getList());
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Student getStudentByStudentname(String username) {
        return studentDao.getStudentByStudentname(username);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public ResultUtil deleteStudentById(int studentId) {
        studentDao.deleteStudentById(studentId);
        return ResultUtil.ok();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public ResultUtil updateStudent(Student student) {
        studentDao.updateStudent(student);
        return ResultUtil.ok();
    }
}
