package ua.com.test.sepspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.test.sepspringboot.models.Car;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {
    @Query("select c from Car c where c.power = :power ")
    List<Car> getCarsByPower(@Param("power") int power);
    @Query("select c from Car c where c.producer = :producer ")
    List<Car> getCarsByProducer(@Param("producer") String producer);
}
