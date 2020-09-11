package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserbyId(int id);

    List<User> listUsers();
}
