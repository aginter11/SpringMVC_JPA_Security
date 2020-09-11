package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Transactional
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);

    }

    @Transactional
    @Override
    public User getUserbyId(int id) {
        return userDao.getUserbyId(id);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
