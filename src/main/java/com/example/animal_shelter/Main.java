package com.example.animal_shelter;

import java.util.ArrayList;

public class Main {

    public static Company company;
    public static Menu m;
    final static int monthConstanta = 31;

    public static void main(String[] args) {

        //Creating Company object and setting name for your new Company
        System.out.println("Select a name of your Animal Shelter");
        String name = Tech.GetInputStringFunction();
        company = new Company(500.0, name);

        //filling out getDogs field collection with created by default 24 Dog objects
        for(int d=0; d<24; d++){
            company.getDogs().add(new Dog().create());
        }

        //filling out getCats field collection with created by default 8 Cat objects
        for(int c=0; c<8; c++){
            company.getCats().add(new Cat().create());
        }

        //filling out getFeeds field collection with created by default calculated amount of Feed objects
        for(int f=0; f<company.calculateFeedsAmount(); f++){
            company.getFeeds().add(new Feed(2.0, 50.0));
        }

        //Start customer menu
        callMenu();

    }

    //Adding created from Menu objects to Company fields
    public static void addToCompany(Coach coach){
        company.getCoaches().add(coach);
    }

    public static void addToCompany(Feed feed, Double amount){
        //calculating of full kit of requested Feed amount cost
        double expenses = (amount*feed.getPrice());

        //Buying Feeds if possible according to Company.capital.
        if(company.getCapital() >= expenses){
            company.setCapital(company.getCapital() - expenses);

            //Adding Feed objects to getFeeds collection
            while(amount>0){
                company.getFeeds().add(feed);
                amount--;
            }

        }else{
            System.out.println("You have no money.");
            callMenu();
        }
    }

    //Creating new Menu object and filling out it with 5 options.
    public static void callMenu(){

        //Default Feed and Coach objects creating for further adding them to Company fields after menu choice.
        Coach coach = new Coach(100.0);
        Feed feed = new Feed(2.0, 50.0);
        m = new Menu(new ArrayList<>());

        System.out.println("\nYour animal shelter: "+company);

        //Filling arrayList for menu creating
        m.arrayMenu.add("Press 1 to hire Coach (monthly salary: $"+coach.getSalary()+")");
        m.arrayMenu.add("Press 2 to buy Feeds (one " +feed.getMass()+ "g Feed costs $"+feed.getPrice()+")");
        m.arrayMenu.add("Press 3 to sell Cat");
        m.arrayMenu.add("Press 4 to sell Dog");
        m.arrayMenu.add("That's enough");

        //Menu builder method calling
        m.menuBuilder();

        //Catching of customer's choice.
        int i = Tech.GetInputFunction();
        if(i==1){
            addToCompany(coach);
            callMenu();
        }else if(i==2){
            System.out.println("Input number of Feed portions you need");
            addToCompany(feed, Double.parseDouble(Tech.GetInputStringFunction()));
            callMenu();
        }else if(i==3) {

            company.sellCat();
            callMenu();

        }else if(i==4) {
            company.sellDog();
            callMenu();

        }else if(i==5){
            company.startMonth();

        }else{
            System.out.println("There is no such number");
            callMenu();
        }
    }
}
