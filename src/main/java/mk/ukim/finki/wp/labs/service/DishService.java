package mk.ukim.finki.wp.labs.service;

import mk.ukim.finki.wp.labs.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
    void deleteDish(String dishId);
}
