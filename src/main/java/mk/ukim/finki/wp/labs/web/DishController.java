package mk.ukim.finki.wp.labs.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.model.User;
import mk.ukim.finki.wp.labs.service.ChefService;
import org.springframework.ui.Model;
import mk.ukim.finki.wp.labs.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }
    @GetMapping("/")
    public String home(HttpServletRequest req) {
        User u = (User) req.getAttribute("auth_user");
        if(u == null) return "redirect:/login";
        return "chefs"; // или dashboard
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
    public String saveDish(@RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime,@RequestParam int rating, @RequestParam Long chefId){
       Chef chef=chefService.findById(chefId);
        Dish dish=new Dish(dishId,name,cuisine,preparationTime,rating,chef);
        dishService.create(dishId,name,cuisine,preparationTime,rating,chef);
        return "redirect:/dishes";
    }
    @PostMapping("/dishes/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime,@RequestParam int rating,@RequestParam Long chefId){
        Chef chef=chefService.findById(chefId);
        Dish dish=dishService.findById(id);
        dish.setPreparationTime(preparationTime);
        dish.setName(name);
        dish.setCusine(cuisine);
        dish.setChef(chef);
        dish.setPreparationTime(preparationTime);
        dish.setDishId(dishId);
        dish.setRating(rating);
        dishService.update(id,dishId,dish.getName(),dish.getCusine(),preparationTime,rating,chefId);
        return "redirect:/dishes";
    }
    @GetMapping("/dishes/form")
    public String openForm(Model model){
        model.addAttribute("dish",null);
        model.addAttribute("chefs",chefService.listChefs());
        return "dish-form";
    }

    @GetMapping("/dishes/search")
    public String search(@RequestParam(required = false) Integer rating,
                         Model model) {

        List<Dish> dishes;

        if (rating != null) {
            dishes = dishService.findByDishrating(rating);
        } else {
            dishes = dishService.listDishes();
        }

        model.addAttribute("dishes", dishes);
        model.addAttribute("rating", rating);

        return "listDishes";
    }




    @PostMapping("/dishes/form/{id}")
    public String openEditForm(@PathVariable Long id,Model model){
        Dish dish=dishService.findById(id);

        model.addAttribute("chefs",chefService.listChefs());
        model.addAttribute("dish",dish);
        model.addAttribute("dishId",dish.getDishId());
        model.addAttribute("name",dish.getName());
        model.addAttribute("cuisine",dish.getCusine());
        model.addAttribute("preparationTime",dish.getPreparationTime());
        model.addAttribute("id",id);
        return "dish-form";
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/dish")
    public String showDishes(@RequestParam Long chefId,Model model){
        Chef chef=chefService.findById(chefId);

        List<Dish> dishes=dishService.listDishes();
        String mostFrequentProduct=chefService.mostFrequentProduct(chefId);
        model.addAttribute("dishes",chef.getDishes());
        model.addAttribute("chef",chef.getFirstName()+" "+chef.getLastName());
        model.addAttribute("chefId",chefId);
        return "dishesList";

    }

    @PostMapping("/chefDetails")
    public String showDetails(@RequestParam Long chefId,@RequestParam Long dishId,Model model){
        Chef chef=chefService.findById(chefId);
        Dish dish=dishService.findById(dishId);
        chefService.addDtC(chefId,dishId);

        model.addAttribute("chef",chef);
        return "chefDetails";
    }

    @PostMapping("/deletefromBucket/{dishId}")
    public String deleteFromBucket(@PathVariable String dishId, @RequestParam Long chefId){
        dishService.deleteFromBucket(dishId,chefId);
        return "redirect:/chefs";
    }


}
