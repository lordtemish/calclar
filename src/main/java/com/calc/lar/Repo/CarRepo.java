package com.calc.lar.Repo;

import com.calc.lar.DataClasses.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepo extends MongoRepository<Car,String> {
    public Car findByid(String id);
    public Car findByname(String name);
    public List<Car> findAll();
    public List<Car> findBymodelid(String modelid);
}
