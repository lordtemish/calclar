package com.calc.lar.Repo;

import com.calc.lar.DataClasses.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BrandRepo extends MongoRepository<Brand, String> {
    public Brand findByid(String id);
    public Brand findByname(String name);
    public List<Brand> findAll();
}
