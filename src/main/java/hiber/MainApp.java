package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user5 = new User("Vladimir", "Putin", "VV@kreml.ru");
      User user6 = new User("Joe", "Biden", "JB@gmail.com");
      User user7 = new User("Kamala", "Harris", "KH@gmail.com");
      User user8 = new User("Sergey", "Lavrov", "SL@mid.ru");


      Car car5 = new Car("BMW", 3);
      Car car6 = new Car("Lada", 1968);
      Car car7 = new Car("Niva", 1975);
      Car car8 = new Car("Honda", 5);

      userService.add(user5.setCar(car5).setUser(user5));
      userService.add(user6.setCar(car6).setUser(user6));
      userService.add(user7.setCar(car7).setUser(user7));
      userService.add(user8.setCar(car8).setUser(user8));


//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
