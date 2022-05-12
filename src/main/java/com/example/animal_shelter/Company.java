package com.example.animal_shelter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Company {

    private Double capital;
    private String name;
    private int neededFeed;
    private ArrayList <Feed> feeds  = new ArrayList<>();
    private ArrayList <Cat> cats = new ArrayList<>();
    private ArrayList <Dog> dogs = new ArrayList<>();
    private ArrayList <Coach> coaches = new ArrayList<>(0);

    public Company(Double capital, String name) {
        this.capital = capital;
        this.name = name;
    }

    public int getNeededFeed() {
        return neededFeed;
    }

    public void setNeededFeed(int neededFeed) {
        this.neededFeed = neededFeed;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<Feed> feeds) {
        this.feeds = feeds;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    public String toString(){
        return "\nName: "+this.getName()+
                "\n"+this.getDogs().size()+" dogs: " + this.getDogs()+
                "\n"+this.getCats().size()+" cats: " + this.getCats()+
                "\nCoaches: "+this.getCoaches().size()+
                "\nCapital: $"+this.getCapital()+
                "\nFeeds available: "+this.getFeeds().size()+
                "\nFeed needs (month): "+this.calculateFeedsAmount()+
                " (mass: "+this.calculateFeedsMass()+"g, cost: $"+this.calculateFeedsCost()+")";
    }

    //Calculating needed Feed objects for Company's amount of Cat and Dog objects in collections
    public int calculateFeedsAmount(){
        int feed =
                (this.getCats().stream().mapToInt(Cat::getFeedingTimes).sum())+
                (this.getDogs().stream().mapToInt(Dog::getFeedingTimes).sum());

        return feed * Main.monthConstanta;
    }

    //Calculating needed Feed objects full cost
    public Double calculateFeedsCost(){
        double fCost =
                (this.getDogs().stream().mapToDouble(Dog::calculateFeedCost).sum())+
                (this.getCats().stream().mapToDouble(Cat::calculateFeedCost).sum());

        return fCost * Main.monthConstanta;
    }

    //Calculating needed Feed objects full mass
    public Double calculateFeedsMass(){
        double fMass =
                (this.getDogs().stream().mapToDouble(Dog::calculateFeedMass).sum())+
                (this.getCats().stream().mapToDouble(Cat::calculateFeedMass).sum());

        return fMass * Main.monthConstanta;
    }

    //Selling Cat or Dog calls new Menu creating that will include all Cat or Dog objects in Company collections
    //Then, wait for customers input of index of object form the Menu and delete this Object from cats or dogs collection of
    //Company object. Price of this Cat or Dog will be added to Company's capital field.
    public void sellCat(){
        ArrayList<String> sellAnimals = new ArrayList<>();
        this.getCats().forEach(cat -> sellAnimals.add(cat.toString()+"("+cat.getPrice()+")"));

        Menu menu = new Menu(sellAnimals);
        menu.menuBuilder();
        System.out.println("Input index of a Cat you wish to sell");
        int choice = Tech.GetInputFunction();
        this.setCapital(this.getCapital()+this.getCats().get((choice-1)).getPrice());
        this.getCats().remove((choice-1));
    }

    public void sellDog(){
        ArrayList<String> sellAnimals = new ArrayList<>();
        this.getDogs().forEach(dog -> sellAnimals.add(dog.toString()+"("+dog.getPrice()+")"));

        Menu menu = new Menu(sellAnimals);
        menu.menuBuilder();
        System.out.println("Input index of a Dog you wish to sell");
        int choice = Tech.GetInputFunction();
        this.setCapital(this.getCapital()+this.getDogs().get((choice-1)).getPrice());
        this.getDogs().remove((choice-1));
    }

    public void startMonth(){

        this.neededFeed = this.calculateFeedsAmount();

        if(feedsControl()){

            if(this.getCoaches() != null){
                coaching();
            }

            //Calling monthOlder method from Animal class for each Cat and Dog objects from Company's collections dogs and cats.
            this.getDogs().forEach(Animal::monthOlder);
            this.getCats().forEach(Animal::monthOlder);

            pairing(
                    this.getCats().stream()
                            .filter(Objects::nonNull)
                            .filter(cat -> cat.getAge()>=12)
                            .filter(cat -> cat.getSex().equals("f"))
                            .parallel().toList().get(0),
                    this.getCats().stream()
                            .filter(Objects::nonNull)
                            .filter(cat -> cat.getAge()>=12)
                            .filter(cat -> cat.getSex().equals("m"))
                            .parallel().toList().get(0)
            );

            pairing(
                    this.getDogs().stream()
                            .filter(Objects::nonNull)
                            .filter(dog -> dog.getAge()>=12)
                            .filter(dog -> dog.getSex().equals("f"))
                            .parallel().toList().get(0),
                    this.getDogs().stream()
                            .filter(Objects::nonNull)
                            .filter(dog -> dog.getAge()>=12)
                            .filter(dog -> dog.getSex().equals("m"))
                            .parallel().toList().get(0)
            );

            //Menu method calling as a start of new month
            Main.callMenu();
        }

    }

    //Gets 2 objects with different sex values of Cat or Dog class. Then checks for breed and if values are equal, then creating from 1 to 5
    //new objects (Cat or Dog) with the same breed has 100% probability.
    // If breed is not equal for 2 received objects, creating of new from 1 to 5 objects (Cat or Dog) objects has 30% probability
    // and these new objects will have "General" value of breed field.
    //All created Cat or Dog objects will be added to Company's cats or dogs collections.
    public void pairing(Cat f, Cat m) {
        System.out.println(f+" was pairing with "+m);

        if(f != null && m != null){
            if(f.getBreed().equals(m.getBreed())){
                for(int i=0; i<Tech.getRandom(1, 5); i++){
                    this.getCats().add(new Cat().born(m.getBreed()));
                }
            }else if(Tech.getRandom(0, 100)<=30){
                for(int i=0; i<Tech.getRandom(1, 5); i++){
                    this.getCats().add(new Cat().born("General"));
                }
            }
        }
    }

    public void pairing(Dog f, Dog m) {
        System.out.println(f+" was pairing with "+m);

        if(f != null && m != null) {
            if (f.getBreed().equals(m.getBreed())) {
                for(int i=0; i<Tech.getRandom(1, 5); i++){
                    this.getDogs().add(new Dog().born(m.getBreed()));
                }
            } else if (Tech.getRandom(0, 100) <= 30) {
                for(int i=0; i<Tech.getRandom(1, 5); i++){
                    this.getDogs().add(new Dog().born("General"));
                }
            }
        }
    }

    //Deduction of coaches objects' salary fields from Company capital
    //Calling methods trainCat or trainDog method for Cat or Dog object from Company's collections
    //by each Coach from Company coaches collection and further exhibition method call of each Cat or Dog, but only if
    //skill of these objects are not 0.
    public void coaching(){

        this.getCoaches().forEach(coach -> this.capital-=coach.getSalary());

        this.getCoaches().forEach(coach -> new AtomicReference<>(this.getCats()).set(coach.trainCat(this.getCats())));
        this.getCoaches().forEach(coach -> new AtomicReference<>(this.getDogs()).set(coach.trainDog(this.getDogs())));

        this.getCats().stream().filter(cat -> cat.getSkill()!=0).forEach(cat -> this.capital+=cat.exhibition());
        this.getDogs().stream().filter(dog -> dog.getSkill()!=0).forEach(dog -> this.capital+=dog.exhibition());

    }

    //Control if the Company object has neededFeed less than Feed.size()
    public boolean feedsControl(){

        if(this.getFeeds().size()<this.neededFeed){
            System.out.println("\n-------------------");
            System.out.println("You need more Feeds");
            System.out.println("-------------------\n");
            Main.callMenu();
            return false;
        }else{
            for(int i=0; i<this.neededFeed; i++){
                this.getFeeds().remove(0);
            }
            return true;
        }
    }

}
