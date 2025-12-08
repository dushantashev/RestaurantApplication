//package mk.ukim.finki.wp.labs.repository;
//
//import mk.ukim.finki.wp.labs.model.Chef;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface ChefRepository extends JpaRepository<Chef, Long> {
//
//    Optional<Chef> findByDishes_DishId(String dishId);
//
//    void deleteByDishes_DishId(String dishId);
//}
