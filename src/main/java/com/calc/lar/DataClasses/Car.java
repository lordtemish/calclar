package com.calc.lar.DataClasses;

import org.springframework.data.annotation.Id;

public class Car {
    @Id
    private String id;
    private String modelid;
    private String name;
    private int startyear;
    private int stopyear;
    private String fuel;
    public class DVS{
        private float liter;
        private String viscosity;
        public DVS(){}
        public DVS(float l, String v){liter=l;viscosity=v;}
        public void setLiter(float liter) { this.liter = liter; }
        public void setViscosity(String viscosity) { this.viscosity = viscosity; }
        public float getLiter() { return liter; }
        public String getViscosity() {return viscosity;}
    }
    public class KPP{
        private String type;
        private float liter;
        private String oilType;
        public KPP(){
        }
        public KPP(String type, float liter, String oilType){
            if(type.equals("M")){
                this.type=KP.MECHANIC.type();
            }
            else{
                this.type=KP.AUTOMATIC.type();
            }
            this.liter=liter;
            this.oilType=oilType;
        }
    }
    public class Freeze{

    }
}
enum KP{
    AUTOMATIC("A"),
    MECHANIC("M");

    private String type;
    KP(String s){
        this.type=s;
    }
    public String type(){
        return type;
    }
        }
