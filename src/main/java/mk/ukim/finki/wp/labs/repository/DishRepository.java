package mk.ukim.finki.wp.labs.repository;



import mk.ukim.finki.wp.labs.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
    void deleteByDishId(String dishId);
    Optional<Dish> findById(Long id);
    Dish save(Dish dish);

}
