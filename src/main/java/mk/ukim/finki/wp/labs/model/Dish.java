package mk.ukim.finki.wp.labs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
//@AllArgsConstructor
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String dishId;
    private String name;
    private String cusine;
    private int preparationTime;
    private static int counter=0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;
    public Dish() {
    }



    public Dish(String dishId, String name, String cusine, int preparationTime,Chef chef) {
//        id= (long) ++counter;
        this.dishId = dishId;
        this.name = name;
        this.cusine = cusine;
        this.preparationTime = preparationTime;
        this.chef=chef;
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

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
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
