package mk.ukim.finki.wp.labs.service.impl;


import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.repository.DishRepository;
import mk.ukim.finki.wp.labs.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return this.dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        Dish dish = this.dishRepository.findByDishId(dishId);
        if (dish == null) {
            throw new RuntimeException("Dish with id: " + dishId + " not found");
        }
        return dish;
    }

    @Override
    public void deleteDish(String dishId) {
        this.dishRepository.deleteByDishId(dishId);
    }
}
