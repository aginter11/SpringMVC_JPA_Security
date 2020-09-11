package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        //     sessionFactory.getCurrentSession().save(user);
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        //   sessionFactory.getCurrentSession().update(user);
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = (User) session.get(User.class, id);
//        if (user != null) {
//            session.delete(user);
//        }
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    public User getUserbyId(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = (User) session.get(User.class, id);

        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();

        return entityManager.createQuery("SELECT u from User u").getResultList();
    }
}
