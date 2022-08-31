package ro.itschool.dto;

import lombok.Data;

@Data
public class DogDTO {
    private long id;
    private int breedId;
    private String name;
    private int age;
    private String city;
    private String description;
    private String imageName;
}

