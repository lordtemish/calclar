package com.calc.lar.Controllers;

import com.calc.lar.Classes.StatusObject;
import com.calc.lar.DataClasses.Brand;
import com.calc.lar.DataClasses.Model;
import com.calc.lar.Repo.BrandRepo;
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
}
