package ssm.service;

import ssm.domain.Contact;
import ssm.util.ResultUtil;

import java.util.List;

public interface ContactServive {
    void addContact(Contact contact);
    public ResultUtil getContactList(Integer page, Integer limit);
    public ResultUtil getContactListByUserId(Integer page, Integer limit,int userid);

}
