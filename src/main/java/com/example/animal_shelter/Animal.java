package com.example.animal_shelter;

public class Animal {

    private String name;
    private String breed;
    private String sex;
    private int feedingTimes;
    private Feed feed;
    private int skill;
    private Double price;
    private int age;


    public Animal(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getFeedingTimes() {
        return feedingTimes;
    }

    public void setFeedingTimes(int feedingTimes) {
        this.feedingTimes = feedingTimes;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }


    //method allows for CAT and DOG objects participate in Exhibition and return profit value for Company. Also increased the price for object
    public Double exhibition(){
        this.price+=(this.skill*2.0);
        double profit = (this.skill*10.0);
        System.out.println("Participation in exhibition of "+this.name+" brings you $"+profit+" and get new prise $"+this.price);

        return profit;
    }

    @Override
    public String toString(){
        return "(Some animal("+this.getSex()+") name: "+this.getName()+" breed: "+this.getBreed()+")";
    }

    //Calculating feed mass for one object Cat or Dog
    public Double calculateFeedMass(){
        return this.getFeedingTimes()*this.getFeed().getMass();
    }

    //Calculating feed cost for one object Cat or Dog
    public Double calculateFeedCost(){
        return this.getFeedingTimes()*this.getFeed().getPrice();
    }

    //Adding +1 month to age for Cat or Dog objects
    public void monthOlder(){
        this.age+=1;
        if(this.age==60){
            this.price/=2;
        }
    }

}
