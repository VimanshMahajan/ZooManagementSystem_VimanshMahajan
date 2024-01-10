package org.IIITD.VM.projects.Zootopia.Deals_and_Discounts;

import java.util.ArrayList;

public class Discount {
    public static ArrayList<Discount> discountArrayList = new ArrayList<>();
    private int lower_bound;
    private int upper_bound;
    private int discount_percentage;
    private String discount_name;

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public int getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(int lower_bound) {
        this.lower_bound = lower_bound;
    }

    public int getUpper_bound() {
        return upper_bound;
    }

    public void setUpper_bound(int upper_bound) {
        this.upper_bound = upper_bound;
    }

    public int getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(int discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public Discount(int lower_bound, int upper_bound, int discount_percentage,String discount_name){
        this.lower_bound = lower_bound;
        this.upper_bound = upper_bound;
        this.discount_percentage = discount_percentage;
        this.discount_name = discount_name;
    }
}
