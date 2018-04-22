package com.calc.lar.Controllers;

import com.calc.lar.Classes.*;
import com.calc.lar.DataClasses.Brand;
import com.calc.lar.DataClasses.Car;
import com.calc.lar.DataClasses.Model;
import com.calc.lar.Repo.BrandRepo;
import com.calc.lar.Repo.CarRepo;
import com.calc.lar.Repo.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    public BrandRepo brandRepo;
    @Autowired
    public ModelRepo modelRepo;
    @Autowired
    public CarRepo carRepo;

    public Object okay=new StatusObject("ok");


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody
    Object getTest(){
        return new StatusObject(true);
    }

    @RequestMapping(value = "/addBrand",method = RequestMethod.POST)
    public @ResponseBody
    Object addBrand(@RequestParam String name){
        try{
            Brand brand=new Brand(name);
            brandRepo.save(brand);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/allBrands",method = RequestMethod.POST)
    public @ResponseBody
    Object allBrands(){
        try{
            return brandRepo.findAll();
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/deleteBrand",method = RequestMethod.POST)
    public @ResponseBody
    Object deleteBrand(@RequestParam String id){
        try{
            Brand brand=brandRepo.findByid(id);
            brandRepo.delete(brand);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/updateBrand",method = RequestMethod.POST)
    public @ResponseBody
    Object updateBrand(@RequestParam String id, @RequestParam String name){
        try{
            Brand brand=brandRepo.findByid(id);
            brand.setName(name);
            brandRepo.save(brand);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }

    @RequestMapping(value = "/addModel", method = RequestMethod.POST)
    public @ResponseBody Object addModel(@RequestParam String brandid, @RequestParam String name){
        try{
            Model model=new Model(name,brandid);
            modelRepo.save(model);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/allModels", method = RequestMethod.POST)
    public @ResponseBody Object allModels(){
        try{
            return modelRepo.findAll();
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/allModelsById", method = RequestMethod.POST)
    public @ResponseBody Object allModels(@RequestParam String id){
        try{
            return modelRepo.findBybrandid(id);
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/deleteModel",method = RequestMethod.POST)
    public @ResponseBody
    Object deleteModel(@RequestParam String id){
        try{
            Model model=modelRepo.findByid(id);
            modelRepo.delete(model);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/updateModel",method = RequestMethod.POST)
    public @ResponseBody
    Object updateModel(@RequestParam String id, @RequestParam String name){
        try{
            Model model=modelRepo.findByid(id);
            model.setName(name);
            modelRepo.save(model);
            return okay;
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/getCars",method = RequestMethod.POST)
    public @ResponseBody Object getCars(){
        return carRepo.findAll();
    }

    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    public @ResponseBody Object addCar(@RequestParam String modelid){
        try{
            carRepo.save(new Car(modelid));
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/addCarWithBasic",method = RequestMethod.POST)
    public @ResponseBody Object addCarWithBasicInfo(@RequestParam String modelid, @RequestParam float liter, @RequestParam int start, @RequestParam int stop, @RequestParam String fuel){
        try{
            Car car=new Car(modelid);
            car.setCapacity(liter);
            car.setStartyear(start);
            car.setStopyear(stop);
            car.setFuel(fuel);
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/deleteCar",method = RequestMethod.POST)
    public @ResponseBody Object deleteCar(@RequestParam String carid){
        try{
            carRepo.delete(carRepo.findByid(carid));
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/deleteAllCars",method = RequestMethod.POST)
    public @ResponseBody Object deleteCars(@RequestParam String carid){
        try{
            carRepo.deleteAll();
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarWithBasic",method = RequestMethod.POST)
    public @ResponseBody Object setCarWithBasicInfo(@RequestParam String carid, @RequestParam float liter, @RequestParam int start, @RequestParam int stop, @RequestParam String fuel){
        try{
            Car car=carRepo.findByid(carid);
            car.setCapacity(liter);
            car.setStartyear(start);
            car.setStopyear(stop);
            car.setFuel(fuel);
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarDVS",method = RequestMethod.POST)
    public @ResponseBody Object addCarDVS(@RequestParam String carid, @RequestParam float liter, @RequestParam String viscocity ){
        try{
            Car car=carRepo.findByid(carid);
            car.setDvs(new DVS(liter,viscocity));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarAKPP",method = RequestMethod.POST)
    public @ResponseBody Object addCarAKPP(@RequestParam String carid, @RequestParam float liter, @RequestParam String oilType ){
        try{
            Car car=carRepo.findByid(carid);
            car.setAKPP(new KPP("A",liter,oilType));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarMKPP",method = RequestMethod.POST)
    public @ResponseBody Object addCarMKPP(@RequestParam String carid,@RequestParam float liter, @RequestParam String oilType ){
        try{
            Car car=carRepo.findByid(carid);
            car.setMKPP(new KPP("M",liter,oilType));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarFreeze",method = RequestMethod.POST)
    public @ResponseBody Object addCarFreeze(@RequestParam String carid, @RequestParam float freezeSystem, @RequestParam String freezeType ){
        try{
            Car car=carRepo.findByid(carid);
            car.setFreeze(new Freeze(freezeSystem,freezeType));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }

    @RequestMapping(value = "/setCarBackReductor",method = RequestMethod.POST)
    public @ResponseBody Object addCarReductor(@RequestParam String carid, @RequestParam float liter, @RequestParam String type ){
        try{
            Car car=carRepo.findByid(carid);
            car.setBackRed(new Reductor(liter,type));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarFrontReductor",method = RequestMethod.POST)
    public @ResponseBody Object addCarFrontReductor(@RequestParam String carid, @RequestParam float liter, @RequestParam String type ){
        try{
            Car car=carRepo.findByid(carid);
            car.setFrontRed(new Reductor(liter,type));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/setCarFilters",method = RequestMethod.POST)
    public @ResponseBody Object addCarFilters(@RequestParam String carid, @RequestParam  String air,@RequestParam String oilDVS,@RequestParam String interior,@RequestParam String fuel,@RequestParam String KPP ){
        try{
            Car car=carRepo.findByid(carid);
            car.setFilters(new Filters(air,oilDVS,interior,fuel,KPP));
            carRepo.save(car);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
}
