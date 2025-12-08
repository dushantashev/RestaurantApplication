package mk.ukim.finki.wp.labs.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@NoArgsConstructor
@Entity
@Table(name = "shop_user")
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    private String role;



    public User(String username, String password, String name, String surname,String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role=role;
    }

}

