package org.IIITD.VM.projects.Zootopia.Deals_and_Discounts;

import java.util.ArrayList;

public class Deals {
    public static ArrayList<Deals> dealsArrayList = new ArrayList<>();
    private int number_of_tickets;
    private int discount;
    private String deal_name;

    public String getDeal_name() {
        return deal_name;
    }

    public void setDeal_name(String deal_name) {
        this.deal_name = deal_name;
    }

    public int getNumber_of_tickets() {
        return number_of_tickets;
    }

    public void setNumber_of_tickets(int number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Deals(int number_of_tickets, int discount,String deal_name) {
        this.number_of_tickets = number_of_tickets;
        this.discount = discount;
        this.deal_name = deal_name;
    }


}
