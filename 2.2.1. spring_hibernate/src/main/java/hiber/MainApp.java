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

         System.out.println(userService.getUserByCarModelAndSeries("Volkswagen Beetle", 1500).get(0));

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
