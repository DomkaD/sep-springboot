package ua.com.test.sepspringboot.models;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import ua.com.test.sepspringboot.views.Views;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = Views.Level1.class)
    private int id;

    @JsonView(value = {Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String model;
    @JsonView(value = {Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String producer;
    @Min(value = 0,message = "power can`t be lt 0")
    @Max(value = 1100, message = "power can`t be ht 1100")
    @JsonView(value = {Views.Level1.class, Views.Level2.class})
    private int power;

    public Car(String model, String producer, int power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
