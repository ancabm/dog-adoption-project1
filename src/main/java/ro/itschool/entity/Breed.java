package ro.itschool.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "breed_id")
    private int id;

    private String name;

}

