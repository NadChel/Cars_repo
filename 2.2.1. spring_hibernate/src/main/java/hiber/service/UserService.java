package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void setCarById(long id, Car car);

    User getUserById(long id);

    List<User> getUserByCarModelAndSeries(String model, int series);

    List<User> listUsers();
}
