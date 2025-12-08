//package mk.ukim.finki.wp.labs.repository.impl;
//
//
//
//import mk.ukim.finki.wp.labs.bootstrap.DataHolder;
//import mk.ukim.finki.wp.labs.model.Chef;
//import mk.ukim.finki.wp.labs.model.Dish;
//import mk.ukim.finki.wp.labs.repository.ChefRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryChefRepository implements ChefRepository {
//
//    @Override
//    public List<Chef> findAll() {
//        return DataHolder.chefs;
//    }
//
//    @Override
//    public Optional<Chef> findById(Long id) {
//        return DataHolder.chefs.stream()
//                .filter(chef -> chef.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public Chef save(Chef chef) {
//        DataHolder.chefs.removeIf(c-> c.getId().equals(chef.getId()));
//        DataHolder.chefs.add(chef);
//        return chef;
//    }
//
//    @Override
//    public void deleteDishFromChef(Chef chef, String dishId) {
//        if (chef.getDishes() != null) {
//            chef.getDishes().removeIf(dish -> dish.getDishId().equals(dishId));
//        }
//        save(chef);
//    }
//
//    @Override
//    public String mostFrequentProduct(Chef chef){
//        List<Dish>dishes=chef.getDishes();
//        if (dishes == null || dishes.isEmpty()) {
//            return null; // или "No dishes"
//        }
//        String mostFrequent = dishes.stream()
//                .collect(Collectors.groupingBy(Dish::getName, Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//        return mostFrequent;
//
//    }
//    //VOa e plus
//    @Override
//    public ArrayList<Chef> findByName(String name){
//
//        return (ArrayList<Chef>) DataHolder.chefs.stream().filter(chef->chef.getFirstName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
//    }
//}
