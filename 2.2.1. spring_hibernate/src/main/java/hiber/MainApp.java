package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      try (AnnotationConfigApplicationContext context =
                   new AnnotationConfigApplicationContext(AppConfig.class)) {

         UserService userService = context.getBean(UserService.class);
//      userService.setCarById(2, new Car("Volkswagen Beetle", 1500));
//      userService.setCarById(3, new Car("Bantam Model 60 Roadster", 1938));
//      userService.setCarById(4, new Car("Daimler Motorized Carriage", 1886));
//      userService.setCarById(5, new Car("Some Boring Car", 1234));
         System.out.println(userService.getUserByCarSeries(1886).get(0));
         System.out.println(userService.getUserByCarModel("Volkswagen Beetle").get(0));

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

         List<User> users = userService.listUsers();
         for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
         }
      }
   }
}
