package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.CleanDao;
import ssm.service.CleanService;
import ssm.util.ResultUtil;

import java.util.List;

@Service
public class CleanServiceImpl implements CleanService {

    @Autowired
    private CleanDao cleanDao;

    @Override
    public ResultUtil getClassList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Clean> cleanList=cleanDao.getCleanList();
        PageInfo<Clean> cleanPageInfo=new PageInfo<>(cleanList);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(cleanPageInfo.getTotal());

        resultUtil.setData(cleanPageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addClean(Clean clean) {
        cleanDao.addClean(clean);
    }

    @Override
    public void updateClean(Clean clean) {
        cleanDao.updateClean(clean);
    }

    @Override
    public Clean getCleanById(Integer cleanId) {
        return cleanDao.getCleanById(cleanId);
    }

    @Override
    public void deleteCleanById(int cleanId) {
        cleanDao.deleteCleanById(cleanId);
    }

    @Override
    public List<Clean> getCleanList() {
        return cleanDao.getCleanList();
    }


}
