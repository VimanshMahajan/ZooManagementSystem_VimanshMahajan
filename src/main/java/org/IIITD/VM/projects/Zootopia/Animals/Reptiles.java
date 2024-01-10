package org.IIITD.VM.projects.Zootopia.Animals;

import java.util.ArrayList;

public class Reptiles implements Animal_property{
    public static ArrayList<Reptiles> reptilesArrayList = new ArrayList<>();

    private static int total = 0;
    private int reptile_ID;
    private String name;
    private String speak;
    private String description;
    private static int visitor_at_reptiles = 0;

    public static int getVisitor_at_reptiles() {
        return visitor_at_reptiles;
    }

    public static void setVisitor_at_reptiles(int visitor_at_reptiles) {
        Reptiles.visitor_at_reptiles = visitor_at_reptiles;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Reptiles.total = total;
    }

    public int getReptile_ID() {
        return reptile_ID;
    }

    public void setReptile_ID(int reptile_ID) {
        this.reptile_ID = reptile_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public void getDescription() {
        System.out.println(this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }





    @Override
    public void sound(){
        System.out.println(this.name+" sound= "+this.speak);
    }

    @Override
    public void description() {
        System.out.println("About the animal: \n"+this.description);
    }

    public Reptiles(String name, String speak, String description) {
        this.reptile_ID = ++total;
        this.name = name;
        this.speak = speak;
        this.description = description;

    }
}
