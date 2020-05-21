package ssm.dao;

import ssm.domain.Contact;

import java.util.List;

public interface ContactDao {
    void addContact(Contact contact);
    List<Contact> getContactList();
    List<Contact> getContactListByUserId(int userId);


}
