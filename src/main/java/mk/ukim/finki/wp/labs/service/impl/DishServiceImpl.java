package mk.ukim.finki.wp.labs.service.impl;


import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.repository.impl.ChefRepository;
import mk.ukim.finki.wp.labs.repository.impl.DishRepository;
import mk.ukim.finki.wp.labs.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DishServiceImpl(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
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
    public Dish findById(Long id) {
       Optional<Dish> dish= dishRepository.findById(id);
        return dish.orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime, Chef chef) {
       if (dishRepository.findByDishId(dishId)!=null){
           dishRepository.deleteByDishId(dishId);
       }
        Dish dish=new Dish(dishId,name,cuisine,preparationTime,chef);

        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime,Long chefId) {
     Chef chef=chefRepository.findChefById(chefId);

        Dish dish=findById(id);
        dish.setDishId(dishId);
        dish.setCusine(cuisine);
        dish.setName(name);
        dish.setChef(chef);
        dish.setPreparationTime(preparationTime);
        return dishRepository.save(dish);

    }

    @Override
    public void delete(Long id) {
      Dish dish=findById(id);
      dishRepository.deleteByDishId(dish.getDishId());
    }

    @Override
    public void deleteDish(String dishId) {
        this.dishRepository.deleteByDishId(dishId);
    }

    @Override
    public void deleteFromBucket(String Id,Long chefId) {
        Chef chef=chefRepository.findChefById(chefId);
        Dish dish=dishRepository.findByDishId(Id);
        chef.getDishes().remove(dish);
        chefRepository.save(chef);

    }
}
