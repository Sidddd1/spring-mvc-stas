package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        User userDel = entityManager.find(User.class, user.getId());
        entityManager.remove(userDel);
    }
}