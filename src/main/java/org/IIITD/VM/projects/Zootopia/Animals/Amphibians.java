package org.IIITD.VM.projects.Zootopia.Animals;

import java.util.ArrayList;

public class Amphibians implements Animal_property{
    public static ArrayList<Amphibians> amphibiansArrayList = new ArrayList<>();

    private static int total = 0;
    private static int mem_visit_amph = 0;

    public static int getMem_visit_amph() {
        return mem_visit_amph;
    }

    public static void setMem_visit_amph(int mem_visit_amph) {
        Amphibians.mem_visit_amph = mem_visit_amph;
    }

    public static int getTotal() {
        return total;
    }

    public int getAmphibian_ID() {
        return amphibian_ID;
    }

    public void setAmphibian_ID(int amphibian_ID) {
        this.amphibian_ID = amphibian_ID;
    }

    public static void setTotal(int total) {
        Amphibians.total = total;
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

    private int amphibian_ID;
    private String name;
    private String speak;
    private String description;

    private static int mem_visit;

    public int getMem_visit() {
        return mem_visit;
    }

    public void setMem_visit(int mem_visit) {
        this.mem_visit = mem_visit;
    }

    @Override
    public void sound() {
        System.out.println(this.name+" sound= "+this.speak);
    }

    @Override
    public void description() {
        System.out.println("About the animal: \n"+this.description);
    }

    public Amphibians(String name, String speak, String description) {
        this.amphibian_ID = ++total;
        this.name = name;
        this.speak = speak;
        this.description = description;
    }
}
