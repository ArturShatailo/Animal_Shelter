package com.example.animal_shelter;

public class Cat extends Animal implements Animals{

    public Cat(String name, String breed, String sex, int feedingTimes, Feed feed, int skill, Double price, int age) {
        super(name, breed, sex, feedingTimes, feed, skill, price, age);
    }
    public Cat(){

    };

    public Cat create(){
        this.setName(names[Tech.getRandom(0, names.length)]);
        this.setBreed(catBreeds[Tech.getRandom(0, catBreeds.length)]);
        this.setSex(sex[Tech.getRandom(0, sex.length)]);
        this.setFeedingTimes(3);
        this.setFeed(new Feed(2.0, 50.0));
        this.setSkill(0);
        this.setPrice(200.0);
        this.setAge(12);
        return this;
    }

    public Cat born(String breed){
        this.setName(names[Tech.getRandom(0, names.length)]);
        this.setBreed(breed);
        this.setSex(sex[Tech.getRandom(0, sex.length)]);
        this.setFeedingTimes(3);
        this.setFeed(new Feed(2.0, 50.0));
        this.setSkill(0);
        this.setPrice(200.0);
        this.setAge(1);
        return this;
    }

    @Override
    public String toString(){
        return "(Cat("+this.getSex()+") name: "+this.getName()+" breed: "+this.getBreed()+")";
    }

}
