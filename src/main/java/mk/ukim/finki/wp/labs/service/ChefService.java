package mk.ukim.finki.wp.labs.service;

import mk.ukim.finki.wp.labs.model.Chef;

import java.util.ArrayList;
import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
    void deleteDishFromChef(Long chefId, String dishId);
    public ArrayList<Chef> findByName(String name);
    public String mostFrequentProduct(Long chefId);

}
