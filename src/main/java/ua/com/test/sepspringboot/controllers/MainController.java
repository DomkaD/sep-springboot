package ua.com.test.sepspringboot.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.test.sepspringboot.dao.CarDAO;
import ua.com.test.sepspringboot.models.Car;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {
    private CarDAO carDAO;

    @GetMapping("/cars")
    public List<Car> getCars(){
        List<Car> all = carDAO.findAll();
        return all;
    }
    @GetMapping("/cars/{id}")
    public Car getCars(@PathVariable int id) {
        Car car = carDAO.findById(id).get();
        return car;
    }
    @PostMapping("/cars")
    public void save(@RequestBody Car car){
        carDAO.save(car);
        return;
    }
    @DeleteMapping("/cars/{id}")
    public List<Car> deleteCar(@PathVariable int id){
        carDAO.deleteById(id);
        return carDAO.findAll();

    }
    @GetMapping("/cars/power/{powerValue}")
    public List<Car> carByPower(@PathVariable int powerValue){
        List<Car> carsByPower = carDAO.getCarsByPower(powerValue);
        return carsByPower;
    }
    @GetMapping("/cars/producer/{producerValue}")
    public List<Car> carByProducer(@PathVariable String producerValue){
        List<Car> carsByProducer = carDAO.getCarsByProducer(producerValue);
        return carsByProducer;
    }


}
