package com.example.animal_shelter;

import java.util.ArrayList;

public class Menu {

    public int fields;
    public ArrayList<String> arrayMenu;

    public Menu(ArrayList<String> arrayMenu) {
        this.arrayMenu = arrayMenu;
    }

    //Menu builder methods creates menu in terminal according to arrayMenu Strings and arrayMenu.size() (length)
    public void menuBuilder(){
        this.fields = arrayMenu.size();
        for(int i=1; i<=this.fields; i++){
            System.out.println(i+") "+ this.arrayMenu.get(i-1));
        }

    }

}
