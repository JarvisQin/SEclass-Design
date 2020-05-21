package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ContactDao;
import ssm.domain.Contact;
import ssm.service.ContactServive;
import ssm.util.ResultUtil;

import java.util.List;

@Service("ContactServive")
public class ContactServiveImpl implements ContactServive {
    @Autowired
    private ContactDao contactDao;

    @Override
    public void addContact(Contact contact){
        contactDao.addContact(contact);
    }


    @Override
    public ResultUtil getContactList(Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<Contact> contacts=contactDao.getContactList();

        return getResultUtil(contacts);
    }
//相同代码
    private ResultUtil getResultUtil(List<Contact> contacts) {
        PageInfo<Contact> pageInfo=new PageInfo<>(contacts);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil getContactListByUserId(Integer page, Integer limit, int userId) {
        PageHelper.startPage(page,limit);
        List<Contact> contacts=contactDao.getContactListByUserId(userId);

        return getResultUtil(contacts);
    }

}
