package ua.com.test.sepspringboot.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.test.sepspringboot.models.Car;
import ua.com.test.sepspringboot.services.CarService;
import ua.com.test.sepspringboot.views.Views;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping(value = "/cars")
public class MainController {
    private CarService carService;

    @GetMapping("")
    @JsonView(value = Views.Level3.class)
    public ResponseEntity<List<Car>> getCars(){
        return carService.findAllResponse();
    }
    @GetMapping("/{id}")
    @JsonView(value = Views.Level1.class)
    public ResponseEntity <Car> getCars(@PathVariable int id) {
        return carService.findCarById(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Car car){
        carService.save(car);
    }
    @DeleteMapping("/{id}")
    public List<Car> deleteCar(@PathVariable int id){
        return carService.deleteByIdCar(id);

    }
    @GetMapping("/power/{powerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carByPower(@PathVariable int powerValue){
       return carService.carListByPower(powerValue);
    }
    @GetMapping("/producer/{producerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carByProducer(@PathVariable String producerValue){
        return carService.carListByProducer(producerValue);
    }


}
