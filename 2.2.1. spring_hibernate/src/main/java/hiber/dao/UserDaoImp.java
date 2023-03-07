package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;
   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   @Override
   public void setCarById(long id, Car car) {
      Session session = sessionFactory.getCurrentSession();
//      session.beginTransaction();
      User user = session.get(User.class, id);
      car.setUser(user);
      user.setCar(car);
//      session.getTransaction().commit();
   }

   @Override
   public User getUserById(long id) {
      Session session = sessionFactory.getCurrentSession();
      return session.get(User.class, id);
   }
   @Override
   public List<User> getUserByCarModelAndSeries(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      return (List<User>) session.createQuery("from User where id = " +
                      "(select userId from Car where model = :m and series = :s)")
              .setParameter("m", model)
              .setParameter("s", series)
              .getResultList();
   }
//   @Override
//   public List<User> getUserByCarSeries(int series) {
//      Session session = sessionFactory.getCurrentSession();
//      return (List<User>) session.createQuery("from User where id = (select userId from Car where series = :s)")
//              .setParameter("s", series)
//              .getResultList();
//   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
