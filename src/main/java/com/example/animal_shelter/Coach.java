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

    //Train methods receive List as an argument and check breed for not "General" and age for >= 12 in objects from List
    //then setting for these objects random values from 1 to 30 in field skill
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
