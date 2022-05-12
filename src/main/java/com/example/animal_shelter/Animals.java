package com.example.animal_shelter;

public interface Animals {

    String [] catBreeds = {"British", "General", "Sphynx", "Maine Coon", "General", "Himalayan", "General"};
    String [] dogBreeds = {"German Shepherd", "General", "Poodle", "General", "Labrador", "Pug", "General"};
    String [] names = {"MILO", "LUNA", "MAX", "OLIVER", "BENTLEY", "LEO", "OLLIE", "LOKI", "BUDDY", "BELLA", "KOBE", "CHARLIE", "JASPER", "WILLOW", "BO", "LUCKY", "BLAZE"};
    String [] sex = {"f", "m"};

    Animal create();
    //Animal pairing(Animal f, Animal m);
    Animal born(String breed);
    Double calculateFeedMass();
    Double calculateFeedCost();
    //String getInfo();

}
