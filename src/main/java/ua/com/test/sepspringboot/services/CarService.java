package ua.com.test.sepspringboot.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.test.sepspringboot.dao.CarDAO;
import ua.com.test.sepspringboot.models.Car;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarDAO carDAO;
    private MailService mailService;

    public void save(Car car) {
        if (car == null) {
            throw new RuntimeException();
        }
        carDAO.save(car);
        mailService.sendEmail(car);

    }

    public ResponseEntity<List<Car>> findAllResponse() {
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Car> findCarById(int id) {
            return new ResponseEntity<>(carDAO.findById(id).get(), HttpStatus.OK);
    }
    public List<Car> deleteByIdCar(int id){
        carDAO.deleteById(id);
        return carDAO.findAll();
    }

    public ResponseEntity<List<Car>> carListByPower(int powerValue) {
        return new ResponseEntity<>(carDAO.getCarsByPower(powerValue), HttpStatus.OK);
    }

    public ResponseEntity<List<Car>> carListByProducer(String producerValue){
        return new ResponseEntity<>(carDAO.getCarsByProducer(producerValue), HttpStatus.OK);
    }


}
