package com.calc.lar.Classes;

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