package mk.ukim.finki.wp.labs.web;


import mk.ukim.finki.wp.labs.model.Chef;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import mk.ukim.finki.wp.labs.service.ChefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }


    @GetMapping("/chefs")
    public String getChefs(@RequestParam(required = false) String error, Model model){
        if (error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("chefs",chefService.listChefs());
        return "listChefs";
    }


    @PostMapping("/chefs/add")
    public String saveChefs(@RequestParam String chefId,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String bio ){

        Chef chef=new Chef();

        chef.setFirstName(firstName);
        chef.setLastName(lastName);
        chef.setBio(bio);
        chef.setDishes(new ArrayList<>());
        chefService.create(chef);
        return "redirect:/chefs";
    }
    @GetMapping("/chefs/add")
    public String showAddChefForm(Model model) {
        model.addAttribute("chef", new Chef());
        return "chefAdd";
    }

    @PostMapping("/chefs/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String editOpenForm(Model model) {

        return "edit";
    }
    @PostMapping("/chefs/edit/{id}")
    public String edit(@PathVariable Long id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String bio){
        Chef chef=chefService.findById(id);
        chef.setBio(bio);
        chef.setLastName(lastName);
        chef.setFirstName(firstName);
        chefService.create(chef);
        return "redirect:/chefs";
    }

    @GetMapping("/chefs/form/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  String editForm(@PathVariable Long id,Model model){
        Chef chef=chefService.findById(id);
        model.addAttribute("chef",chef);
        return "edit";

    }


    @GetMapping("/chefs/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id,Model model){

        chefService.deleteChefById(id);
        return "redirect:/chefs";
    }






}
