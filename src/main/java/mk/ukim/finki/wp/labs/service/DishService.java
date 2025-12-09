package mk.ukim.finki.wp.labs.service;

import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
    Dish findById(Long id);
    Dish create(String dishId, String name, String cuisine, int preparationTime,int rating, Chef chef);
    Dish update(Long id, String dishId, String name, String cuisine, int preparationTime,int rating,Long chefId);
    void delete(Long id);
    void deleteDish(String dishId);
    public void deleteFromBucket(String Id,Long chedId);
    public List<Dish> findByDishrating(int rating);
}
