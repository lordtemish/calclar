package com.calc.lar.Repo;

import com.calc.lar.DataClasses.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModelRepo extends MongoRepository<Model,String> {
    public Model findByid(String id);
    public Model findByname(String name);
    public List<Model> findBybrandid(String brandid);
    public List<Model> findAll();
}
