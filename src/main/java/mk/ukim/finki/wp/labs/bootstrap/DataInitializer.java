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
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            DishRepository dishRepository,
            ChefRepository chefRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {


            Dish d1 = new Dish();
            d1.setDishId("DISH-1");
            d1.setName("Pizza Margherita");
            d1.setCusine("Italian");
            d1.setPreparationTime(15);

            dishRepository.save(d1);


            Chef chef1 = new Chef();
            chef1.setFirstName("Diego");
            chef1.setLastName("Holland");
            chef1.setBio("Professional chef");

            chefRepository.save(chef1);


            User adminCheck = userRepository.findByUsername("admin");
            if (adminCheck == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole("ROLE_ADMIN");


                userRepository.save(admin);
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user"));
                user.setRole("ROLE_USER");


                userRepository.save(user);
            }
        };
    }
}

