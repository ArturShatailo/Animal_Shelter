package com.example.animal_shelter;

import java.util.ArrayList;

public class Coach {

    private Double salary;

    public Coach(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public ArrayList<Cat> trainCat(ArrayList<Cat> cats){
        for(Cat cat: cats){
            if(!cat.getBreed().equals("General")){
                cat.setSkill(cat.getSkill()+Tech.getRandom(1, 30));
            }
        }
        return cats;
    }
    public ArrayList<Dog> trainDog(ArrayList<Dog> dogs){
        for(Dog dog: dogs){
            if(!dog.getBreed().equals("General")){
                dog.setSkill(dog.getSkill()+Tech.getRandom(1, 30));
            }
        }
        return dogs;
    }
}
