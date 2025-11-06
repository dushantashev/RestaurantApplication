package mk.ukim.finki.wp.labs.repository.impl;
import mk.ukim.finki.wp.labs.bootstrap.DataHolder;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream()
                .filter(dish -> dish.getDishId().equals(dishId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteByDishId(String dishId) {
        DataHolder.dishes.removeIf(c -> c.getDishId().equals(dishId));
    }

}
