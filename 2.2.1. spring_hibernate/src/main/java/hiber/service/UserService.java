package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    void setCarById(long id, Car car);

    @Transactional
    User getUserById(long id);

    @Transactional
    List<User> getUserByCarModel(String model);

    @Transactional
    List<User> getUserByCarSeries(int series);

    List<User> listUsers();
}
