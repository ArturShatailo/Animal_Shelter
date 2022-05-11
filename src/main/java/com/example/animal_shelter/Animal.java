package com.example.animal_shelter;

public class Animal {

    private String name;
    private String breed;
    private String sex;
    private int feedingTimes;
    private Feed feed;
    private int skill;
    private Double price;



    public Animal(String name, String breed, String sex, int feedingTimes, Feed feed, int skill, Double price) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.feedingTimes = feedingTimes;
        this.feed = feed;
        this.skill = skill;
        this.price = price;
    }

    public Animal(){

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

    public Double exhibition(){
        this.price+=(this.skill*2.0);
        double profit = (this.skill*10.0);
        System.out.println("Participation in exhibition of "+this.name+" brings you $"+profit+" and get new prise $"+this.price);

        return profit;
    }

    public void pairing(){

    }

    @Override
    public String toString(){
        return "(Some animal("+this.getSex()+") name: "+this.getName()+" breed: "+this.getBreed()+")";
    }

    public Double calculateFeedMass(){
        return this.getFeedingTimes()*this.getFeed().getMass();
    }
    public Double calculateFeedCost(){
        return this.getFeedingTimes()*this.getFeed().getPrice();
    }
}
