package mk.ukim.finki.wp.labs.web;

import jakarta.websocket.server.PathParam;
import mk.ukim.finki.wp.labs.model.Dish;
import org.springframework.ui.Model;
import mk.ukim.finki.wp.labs.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public String getDishesPage(@RequestParam(required = false) String error, Model model){
    if (error!=null&& !error.isEmpty()){
        model.addAttribute("hasError",true);
        model.addAttribute("error",error);
    }

    model.addAttribute("dishes",dishService.listDishes());
    return "listDishes";
    }


    @GetMapping("/dishes/delete/{id}")
    public String deleteDishes(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @PostMapping("/dishes/add")
    public String saveDish(@RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime){
        Dish dish=new Dish(dishId,name,cuisine,preparationTime);
        dishService.create(dishId,name,cuisine,preparationTime);
        return "redirect:/dishes";
    }
    @PostMapping("/dishes/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime){
        Dish dish=dishService.findById(id);
        dish.setPreparationTime(preparationTime);
        dish.setName(name);
        dish.setCusine(cuisine);
        dish.setPreparationTime(preparationTime);
        dish.setDishId(dishId);
        dishService.create(dish.getDishId(),dish.getName(),dish.getCusine(),dish.getPreparationTime());
        return "redirect:/dishes";
    }
    @GetMapping("/dishes/form")
    public String openForm(){
        return "dish-form";
    }
    @PostMapping("/dishes/form/{id}")
    public String openEditForm(@PathVariable Long id,Model model){
        Dish dish=dishService.findById(id);
        model.addAttribute("dish",dish);
        model.addAttribute("dishId",dish.getDishId());
        model.addAttribute("name",dish.getName());
        model.addAttribute("cuisine",dish.getCusine());
        model.addAttribute("preparationTime",dish.getPreparationTime());
        model.addAttribute("id",id);
        return "dish-form";
    }


}
