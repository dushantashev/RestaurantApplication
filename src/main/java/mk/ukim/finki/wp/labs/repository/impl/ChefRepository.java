package mk.ukim.finki.wp.labs.repository.impl;

import mk.ukim.finki.wp.labs.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {

    Optional<Chef> findByDishes_DishId(String dishId);
    ArrayList<Chef> findByFirstName(String name);
    Chef findChefById(Long id);
    @Query("""
    SELECT d.cusine
    FROM Chef c 
    JOIN c.dishes d
    WHERE c = :chef
    GROUP BY d.cusine
    ORDER BY COUNT(d.cusine) DESC
    LIMIT 1
""")
    String mostFrequentCusineByChef(@Param("chef") Chef chef);

    void deleteByDishes_DishId(String dishId);
}
