package com.calc.lar.DataClasses;

import org.springframework.data.annotation.Id;

public class Brand {
    @Id
    private String id;
    private String name;
    public Brand(){}
    public Brand(String n){
        name=n;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
