package mk.ukim.finki.wp.labs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
//@AllArgsConstructor
public class Dish {
    private Long id;
    private String dishId;
    private String name;
    private String cusine;
    private int preparationTime;
    private static int counter=0;
    public Dish() {
    }



    public Dish(String dishId, String name, String cusine, int preparationTime) {
        id= (long) ++counter;
        this.dishId = dishId;
        this.name = name;
        this.cusine = cusine;
        this.preparationTime = preparationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
