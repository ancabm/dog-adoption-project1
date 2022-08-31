package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="breed_id", referencedColumnName  ="breed_id")

    private Breed breed;
    private int age;
    private String city;
    private String description;
    private String imageName;
}

