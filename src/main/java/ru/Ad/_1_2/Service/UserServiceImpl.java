package ru.Ad._1_2.Service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Ad._1_2.DAO.UserDAO;
import ru.Ad._1_2.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Transactional
    @Override
    public List<User> showALL() {
        return userDAO.showALL();
    }
@Transactional
    @Override
    public User showOne(int id) {
        return userDAO.showOne(id);
    }
    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);

    }
    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);

    }
    @Transactional
    @Override
    public void update(int id, User updateUser) {
        userDAO.update(id, updateUser);

    }
}
