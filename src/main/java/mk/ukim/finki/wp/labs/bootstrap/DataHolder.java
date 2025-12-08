package mk.ukim.finki.wp.labs.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Component
public class DataHolder {

    public static List<Chef> chefs =new ArrayList<>();
    public static List<Dish> dishes=new ArrayList<>();


    @PostConstruct
    public void init() {
//        dishes = new ArrayList<>();
//        dishes.add(new Dish("1", "Burger", "American", 15));
//        dishes.add(new Dish("2", "Fried Chicken", "American", 20));
//        dishes.add(new Dish("3", "Pizza", "Italian", 18));
//        dishes.add(new Dish("4", "Hot Dog", "American", 10));
//        dishes.add(new Dish("5", "Mac and Cheese", "American", 12));




        chefs = new ArrayList<>();
        chefs.add(new Chef(1L, "John", "Smith", "Chef for 2 years", new ArrayList<>()));
        chefs.add(new Chef(2L, "Emily", "Johnson", "Private chef on a yacht", new ArrayList<>()));
        chefs.add(new Chef(3L, "Michael", "Brown", "Professional chef for 3 years", new ArrayList<>()));
        chefs.add(new Chef(4L, "Sarah", "Davis", "Chef still in school", new ArrayList<>()));
        chefs.add(new Chef(5L, "David", "Wilson", "Restaurant owner in Italy", new ArrayList<>()));


    }

}
