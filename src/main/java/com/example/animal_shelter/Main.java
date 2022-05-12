package com.example.animal_shelter;

import java.util.ArrayList;

public class Main {

    public static Company company;
    public static Menu m;
    final static int monthConstanta = 31;

    public static void main(String[] args) {

        System.out.println("Select a name of your Animal Shelter");
        String name = Tech.GetInputStringFunction();
        company = new Company(500.0, name);

        for(int d=0; d<24; d++){
            company.getDogs().add(new Dog().create());
        }
        for(int c=0; c<8; c++){
            company.getCats().add(new Cat().create());
        }
        for(int f=0; f<company.calculateFeedsAmount(); f++){
            company.getFeeds().add(new Feed(2.0, 50.0));
        }

        callMenu();

    }

    public static void addToCompany(Coach coach){
        company.getCoaches().add(coach);
    }

    public static void addToCompany(Feed feed, Double amount){
        double expenses = (amount*feed.getPrice());
        if(company.getCapital() >= expenses){
            company.setCapital(company.getCapital() - expenses);

            while(amount>0){
                company.getFeeds().add(feed);
                amount--;
            }

        }else{
            System.out.println("You have no money.");
            callMenu();
        }
    }

    public static void callMenu(){

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
