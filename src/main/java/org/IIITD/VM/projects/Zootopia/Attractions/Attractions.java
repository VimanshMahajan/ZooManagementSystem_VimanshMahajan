package org.IIITD.VM.projects.Zootopia.Attractions;

import java.util.ArrayList;

public class Attractions {
    private static int unique_ID = 0;
    public static ArrayList<Attractions> attraction_list = new ArrayList<>();


    int attraction_ID;
    private String name;
    private int price;
    private int users;
    private int timings;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimings() {
        return timings;
    }

    public void setTimings(int timings) {
        this.timings = timings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getAttraction_ID() {
        return attraction_ID;
    }

    public Attractions(String name, int price, int timings,String description){
        this.setName(name);
        this.setPrice(price);
        this.attraction_ID = ++unique_ID;
        this.setUsers(0);
        this.setTimings(timings); // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.setDescription(description);
    }


}
