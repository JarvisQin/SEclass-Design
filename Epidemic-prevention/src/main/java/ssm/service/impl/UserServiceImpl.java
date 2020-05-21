package ssm.service.impl;

import org.apache.ibatis.annotations.Param;
import ssm.domain.User;
import ssm.service.UserService;

public class UserServiceImpl implements UserService{


    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User getInfoByUsername(String username) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }
}
