package mk.ukim.finki.wp.labs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Dish {
    private String dishId;
    private String name;
    private String cusine;
    private int preparationTime;

    public Dish() {
    }

    public Dish(String dishId, String name, String cusine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cusine = cusine;
        this.preparationTime = preparationTime;
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
