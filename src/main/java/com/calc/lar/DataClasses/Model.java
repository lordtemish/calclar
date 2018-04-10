package com.calc.lar.DataClasses;

import org.springframework.data.annotation.Id;

public class Model {
    @Id
    private String id;
    private String name;
    private String brandid;
    public Model(){}
    public Model(String name, String brandid){
        this.brandid=brandid;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }
}
