package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.DormitoryDao;
import ssm.service.DormitoryService;
import ssm.util.ResultUtil;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryDao dormitoryDao;

    @Override
    public List<Dormitory> getAllDormitories() {
        return dormitoryDao.getAllDormitories();
    }


    @Override
    public ResultUtil getDormitoryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Dormitory> dormitories=dormitoryDao.getDormitoryList();
        PageInfo<Dormitory> dormitoryPageInfo=new PageInfo<>(dormitories);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(dormitoryPageInfo.getTotal());

        resultUtil.setData(dormitoryPageInfo.getList());
        return resultUtil;
    }

    @Override
    public Dormitory checkDormitoryNumber(String dormitoryNumber) {
        return dormitoryDao.checkDormitoryNumber(dormitoryNumber);
    }

    @Override
    public void addDormitory(Dormitory dormitory) {
        dormitoryDao.addDormitory(dormitory);
    }

    @Override
    public void deleteByDormitoryId(int dormitoryId) {
        dormitoryDao.deleteByDormitoryId(dormitoryId);
    }

    @Override
    public Dormitory getDormitoryById(int dormitoryId) {
        return dormitoryDao.getDormitoryById(dormitoryId);
    }
}
