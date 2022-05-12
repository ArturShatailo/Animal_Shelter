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

//        cats.stream()
//                .filter(cat -> !cat.getBreed().equals("General") && cat.getAge()>=12)
//                .forEach(cat -> cat.setSkill(cat.getSkill()+Tech.getRandom(1, 30)));

        for(Cat cat: cats){
            if(!cat.getBreed().equals("General") && cat.getAge()>=12){
                cat.setSkill(cat.getSkill()+Tech.getRandom(1, 30));
            }
        }
        return cats;
    }
    public ArrayList<Dog> trainDog(ArrayList<Dog> dogs){
        for(Dog dog: dogs){
            if(!dog.getBreed().equals("General") && dog.getAge()>=12){
                dog.setSkill(dog.getSkill()+Tech.getRandom(1, 30));
            }
        }
        return dogs;
    }
}
