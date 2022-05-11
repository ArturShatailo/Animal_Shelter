package com.example.animal_shelter;

public class Dog extends Animal implements Animals{

    public Dog(String name, String breed, String sex, int feedingTimes, Feed feed, int skill, Double price) {
        super(name, breed, sex, feedingTimes, feed, skill, price);
    }

    public Dog(){

    }

    public Dog create(){
        this.setName(names[Tech.getRandom(0, names.length)]);
        this.setBreed(dogBreeds[Tech.getRandom(0, dogBreeds.length)]);
        this.setSex(sex[Tech.getRandom(0, sex.length)]);
        this.setFeedingTimes(3);
        this.setFeed(new Feed(2.0, 50.0));
        this.setPrice(200.0);
        this.setSkill(0);
        return this;
    }

    public Dog born(String breed){
        this.setName(names[Tech.getRandom(0, names.length)]);
        this.setBreed(breed);
        this.setSex(sex[Tech.getRandom(0, sex.length)]);
        this.setFeedingTimes(3);
        this.setFeed(new Feed(2.0, 50.0));
        this.setPrice(200.0);
        this.setSkill(0);
        return this;
    }

    @Override
    public String toString(){
        return "(Dog("+this.getSex()+") name: "+this.getName()+" breed: "+this.getBreed()+")";
    }

}

