package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.FixDao;
import ssm.service.FixService;
import ssm.util.ResultUtil;

import java.util.List;

@Service
public class FixServiceImpl implements FixService {

    @Autowired
    private FixDao fixDao;

    @Override
    public ResultUtil getFixList(Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<Fix> fixes=fixDao.getFixList();
        PageInfo<Fix> fixPageInfo=new PageInfo<>(fixes);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(fixPageInfo.getTotal());

        resultUtil.setData(fixPageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addFix(Fix fix) {
        fixDao.addFix(fix);
    }

    @Override
    public Fix getFixById(int fixId) {
        return fixDao.getFixById(fixId);
    }

    @Override
    public void updateFix(Fix fix) {
        fixDao.updateFix(fix);
    }

    @Override
    public void deleteFixById(int fixId) {
        fixDao.deleteFixById(fixId);
    }


}
