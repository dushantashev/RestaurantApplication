package mk.ukim.finki.wp.labs.service.impl;

import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.repository.ChefRepository;
import mk.ukim.finki.wp.labs.repository.DishRepository;
import mk.ukim.finki.wp.labs.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    final private ChefRepository chefRepository;
    final protected DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return this.chefRepository.findAll();
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {

        Chef chef = chefRepository.findById(chefId)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        Dish dish = dishRepository.findByDishId(dishId);
        if (dish == null) {
            throw new RuntimeException("Dish not found");
        }

        if (chef.getDishes() == null) {
            chef.setDishes(new ArrayList<>());
        }

        chef.getDishes().add(dish);
        return chefRepository.save(chef);

    }

    @Override
    public Chef findById(Long id) {
        return this.chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chef with id: " + id + " not found"));
    }

    @Override
    public void deleteDishFromChef(Long chefId, String dishId) {
        Chef chef = chefRepository.findById(chefId)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        if (chef.getDishes() != null) {
            chef.getDishes().removeIf(dish -> dish.getDishId().equals(dishId));
        }

        chefRepository.save(chef);
    }
    @Override
    public ArrayList<Chef>findByName(String name){
        return chefRepository.findByName(name);
    }
    @Override
    public String mostFrequentProduct(Long chefId){
        Chef chef=chefRepository.findById(chefId).orElseThrow(()->new RuntimeException("Not FOund chef"));
        return chefRepository.mostFrequentProduct(chef);
    }

}
