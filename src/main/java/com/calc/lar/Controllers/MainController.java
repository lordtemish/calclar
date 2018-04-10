package com.calc.lar.Controllers;

import com.calc.lar.Classes.StatusObject;
import com.calc.lar.DataClasses.Brand;
import com.calc.lar.Repo.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    public BrandRepo brandRepo;

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
            return new StatusObject(brand);
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
    @RequestMapping(value = "/deleteBrand/{id}",method = RequestMethod.POST)
    public @ResponseBody
    Object deleteBrand(@PathVariable("id") String id){
        try{
            Brand brand=brandRepo.findByid(id);
            brandRepo.delete(brand);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
    @RequestMapping(value = "/updateBrand/{id}",method = RequestMethod.POST)
    public @ResponseBody
    Object updateBrand(@PathVariable("id") String id, @RequestParam String name){
        try{
            Brand brand=brandRepo.findByid(id);
            brand.setName(name);
            brandRepo.save(brand);
            return new StatusObject("ok");
        }
        catch (Exception e){
            return new StatusObject(e.getMessage());
        }
    }
}
