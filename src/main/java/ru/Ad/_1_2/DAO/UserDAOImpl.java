package ru.Ad._1_2.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.Ad._1_2.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showALL() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }


    @Override
    public User showOne(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void save(User user) {
         entityManager.persist(user);
    }


    @Override
    public void delete(int id) {
        entityManager.remove(showOne(id));
    }

    @Override
    public void update(int id, User newUser) {
        User update = entityManager.find(User.class, id);
        update.setName(newUser.getName());
        update.setLast_name(newUser.getLast_name());
        entityManager.persist(update);

    }
}
