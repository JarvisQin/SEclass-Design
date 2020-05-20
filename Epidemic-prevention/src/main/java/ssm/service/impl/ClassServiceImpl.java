package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ClassDao;
import ssm.service.ClassService;
import ssm.util.ResultUtil;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<DClass> getAllClasses() {
        return classDao.getAllClasses();
    }

    @Override
    public ResultUtil getClassList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<DClass> classes=classDao.getClassList();
        PageInfo<DClass> classPageInfo=new PageInfo<>(classes);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(classPageInfo.getTotal());

        resultUtil.setData(classPageInfo.getList());
        return resultUtil;
    }

    @Override
    public void deleteByClassId(int classId) {
        classDao.deleteByClassId(classId);
    }

    @Override
    public DClass getClassById(int classId) {
        return classDao.getClassById(classId);
    }

    @Override
    public DClass getClassByClassName(String className) {
        return classDao.getClassByClassName(className);
    }

    @Override
    public ResultUtil updateClass(DClass dclass) {
        try{
            classDao.updateClass(dclass);
            return ResultUtil.ok();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public void addClass(DClass dclass) {
        classDao.insertClass(dclass);
    }
}
