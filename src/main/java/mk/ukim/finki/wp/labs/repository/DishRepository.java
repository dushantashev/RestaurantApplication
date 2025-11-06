package mk.ukim.finki.wp.labs.repository;



import mk.ukim.finki.wp.labs.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
    void deleteByDishId(String dishId);
}
