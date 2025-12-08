package mk.ukim.finki.wp.labs.repository.impl;

import mk.ukim.finki.wp.labs.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DishRepository extends JpaRepository<Dish, Long> {


    Dish findByDishId(String dishId);
    void deleteByDishId(String dishId);
}