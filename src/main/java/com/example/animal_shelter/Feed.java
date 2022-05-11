package com.example.animal_shelter;

public class Feed {
    private Double price;
    private Double mass;

    public Feed(Double price, Double mass) {
        this.price = price;
        this.mass = mass;
    }

    public Double getPrice() {
        return price;
    }

    public Double getMass() {
        return mass;
    }
}
