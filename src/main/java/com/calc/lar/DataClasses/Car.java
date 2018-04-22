package com.calc.lar.DataClasses;

import com.calc.lar.Classes.*;
import org.springframework.data.annotation.Id;

import java.io.File;
import java.io.FileReader;

public class Car {
    @Id
    private String id;
    private String modelid;
    private String name;
    private int startyear;
    private int stopyear;
    private float capacity;
    private String fuel;
    private DVS dvs;
    private KPP AKPP;
    private KPP MKPP;
    private Freeze freeze;
    private Reductor frontRed;
    private Reductor backRed;
    private Filters filters;
    public Car(){
    }
    public Car(String modelid){
        this.modelid=modelid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCapacity() {
        return capacity;
    }

    public DVS getDvs() {
        return dvs;
    }

    public Filters getFilters() {
        return filters;
    }

    public Freeze getFreeze() {
        return freeze;
    }

    public int getStartyear() {
        return startyear;
    }

    public int getStopyear() {
        return stopyear;
    }

    public KPP getAKPP() {
        return AKPP;
    }

    public KPP getMKPP() {
        return MKPP;
    }

    public Reductor getBackRed() {
        return backRed;
    }

    public Reductor getFrontRed() {
        return frontRed;
    }

    public String getFuel() {
        return fuel;
    }

    public String getModelid() {
        return modelid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAKPP(KPP AKPP) {
        this.AKPP = AKPP;
    }

    public void setBackRed(Reductor backRed) {
        this.backRed = backRed;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public void setDvs(DVS dvs) {
        this.dvs = dvs;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public void setFreeze(Freeze freeze) {
        this.freeze = freeze;
    }

    public void setFrontRed(Reductor frontRed) {
        this.frontRed = frontRed;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setMKPP(KPP MKPP) {
        this.MKPP = MKPP;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }

    public void setStopyear(int stopyear) {
        this.stopyear = stopyear;
    }
}
