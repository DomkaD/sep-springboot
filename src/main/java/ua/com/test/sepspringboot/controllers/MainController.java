package ua.com.test.sepspringboot.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.test.sepspringboot.dao.CarDAO;
import ua.com.test.sepspringboot.models.Car;
import ua.com.test.sepspringboot.views.Views;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping(value = "/cars")
public class MainController {
    private CarDAO carDAO;

    @GetMapping("")
    @JsonView(value = Views.Level3.class)
    public ResponseEntity<List<Car>> getCars(){
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @JsonView(value = Views.Level1.class)
    public ResponseEntity<Car> getCars(@PathVariable int id) {
        return new ResponseEntity<>(carDAO.findById(id).get(), HttpStatus.OK);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Car car){
        carDAO.save(car);
    }
    @DeleteMapping("/{id}")
    public List<Car> deleteCar(@PathVariable int id){
        carDAO.deleteById(id);
        return carDAO.findAll();

    }
    @GetMapping("/power/{powerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carByPower(@PathVariable int powerValue){
        return new ResponseEntity<>(carDAO.getCarsByPower(powerValue), HttpStatus.OK);
    }
    @GetMapping("/producer/{producerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carByProducer(@PathVariable String producerValue){
        return new ResponseEntity<>(carDAO.getCarsByProducer(producerValue), HttpStatus.OK);
    }


}
