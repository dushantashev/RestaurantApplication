package mk.ukim.finki.wp.labs.bootstrap;

import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.model.Role;
import mk.ukim.finki.wp.labs.model.User;
import mk.ukim.finki.wp.labs.repository.impl.DishRepository;
import mk.ukim.finki.wp.labs.repository.impl.ChefRepository;
import mk.ukim.finki.wp.labs.repository.impl.ChefRepository;
import mk.ukim.finki.wp.labs.repository.impl.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
@Bean
CommandLineRunner initData(DishRepository dishRepository, ChefRepository chefRepository, UserRepository userRepository){
    return args -> {
//      Dish d1=new Dish();
//      d1.setDishId("Dish-1");
//      d1.setName("Pizza Marharita");
//      d1.setCusine("Italian");
//      d1.setPreparationTime(15);
//
//      Dish d2 = new Dish();
//      d2.setDishId("DISH-2");
//      d2.setName("Sushi Roll");
//      d2.setCusine("Japanese");
//      d2.setPreparationTime(20);
//
//
//        dishRepository.save(d1);
//        dishRepository.save(d2);
//
//
//
//        Chef chef1=new Chef();
//
//        chef1.setFirstName("Diego");
//        chef1.setLastName("Holand");
//        chef1.setBio("dfsdf");
//
//        Chef chef2=new Chef();
//        chef1.setFirstName("Hugo");
//        chef1.setLastName("Roll");
//        chef1.setBio("fdfs");
//
//        chefRepository.save(chef1);
//        chefRepository.save(chef2);
//        User user1 = new User();
//        user1.setUsername("dushan");
//        user1.setPassword("dushan"); // {noop} за plain text password
//        user1.setRole(Role.USER);
//
//        userRepository.save(user1);
    };

}

}
