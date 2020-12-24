package service.confereeService.impl;

import dao.confereeDao.UserDao;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.UserService;
import vo.confereeVo.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {


        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {

        return userDao.queryUserByUsernameAndPassword(user.getName(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {

        if (userDao.queryUserByUsername(username)!=null)
            return true;
        else
            return false;
    }

    @Override
    public void updatePassword(User user) {
        userDao.updateUser(user);
    }
}
