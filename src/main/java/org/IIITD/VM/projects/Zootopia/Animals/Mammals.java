package org.IIITD.VM.projects.Zootopia.Animals;

import java.util.ArrayList;

public class Mammals implements Animal_property{
    public static ArrayList<Mammals> mammalsArrayList = new ArrayList<>();
    private static int total = 0;
    int mammal_ID;
    private String name;
    private String speak;
    private String description;
    private static int mem_visit_mammals;

    public static int getMem_visit_mammals() {
        return mem_visit_mammals;
    }

    public static void setMem_visit_mammals(int mem_visit_mammals) {
        Mammals.mem_visit_mammals = mem_visit_mammals;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Mammals.total = total;
    }

    public int getMammal_ID() {
        return mammal_ID;
    }

    public void setMammal_ID(int mammal_ID) {
        this.mammal_ID = mammal_ID;
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
        System.out.println("description: "+this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void sound() {
        System.out.println(this.name+" sound= "+this.speak);
    }

    @Override
    public void description() {
        System.out.println("About the animal: \n"+this.description);

    }

    public Mammals(String name, String speak, String description) {
        this.mammal_ID = ++Mammals.total;
        this.name = name;
        this.speak = speak;
        this.description = description;
    }
}
