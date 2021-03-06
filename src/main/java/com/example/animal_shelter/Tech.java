package com.example.animal_shelter;

import java.util.Scanner;

public class Tech {

    //"GetInputFunction" is a scanner of input that returns Integer entered by user
    public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    //"GetInputStringFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    //Get random value from min to max
    public static int getRandom(int min, int max){
        return (int) (Math.random()*(max-min))+min;
    }

}
