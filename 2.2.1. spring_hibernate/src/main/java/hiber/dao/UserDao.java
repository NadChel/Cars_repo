package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   void setCarById(long id, Car car);

    User getUserById(long id);

    List<User> getUserByCarModel(String model);

    List<User> getUserByCarSeries(int series);

    List<User> listUsers();
}
