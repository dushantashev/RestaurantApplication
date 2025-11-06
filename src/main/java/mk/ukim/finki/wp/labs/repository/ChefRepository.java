package mk.ukim.finki.wp.labs.repository;

import mk.ukim.finki.wp.labs.model.Chef;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
    void deleteDishFromChef(Chef chef, String dishId);
    ArrayList<Chef> findByName(String name);
    public String mostFrequentProduct(Chef chef);
}
