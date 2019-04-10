package com.example.bodymassindex;

public class Calculation {
 private float height,weight;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public double calculate_bmi(){
        height=this.height/100;
        height=height*height;


        return  this.weight/height;
    }

}
