package org.IIITD.VM.projects.Zootopia.Members;

import org.IIITD.VM.projects.Zootopia.Animals.Amphibians;
import org.IIITD.VM.projects.Zootopia.Animals.Mammals;
import org.IIITD.VM.projects.Zootopia.Animals.Reptiles;
import org.IIITD.VM.projects.Zootopia.Attractions.Attractions;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Scanner;

public class PremiumMembers extends AbstractMembers{
    public static ArrayList<PremiumMembers> premiumMembersArrayList = new ArrayList<>();
    public static ArrayList<String> feedback = new ArrayList<>();
    public static void feedback_to_string(){
        for(int i = 0;i<feedback.size();i++){
            System.out.println("---> "+feedback.get(i));
        }
    }
    private String name;
    private int age;
    private String phone_num;
    private int balance;
    private String Email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public PremiumMembers(BasicMembers obj){
        this.age = obj.getAge();
        this.name = obj.getName();
        this.balance = obj.getBalance();
        this.password = obj.getPassword();
        this.phone_num = obj.getPhone_num();
        this.Email = obj.getEmail();
    }

//    public PremiumMembers member_login(){
//        Scanner inp = new Scanner(System.in); //string input;
//        System.out.println("Enter your email: ");
//        String email = inp.nextLine();
//        System.out.println("Enter your password: ");
//        String pass = inp.nextLine();
//
//        for(int i = 0;i<PremiumMembers.premiumMembersArrayList.size();i++){
//            if(PremiumMembers.premiumMembersArrayList.get(i).getEmail().equals(email) && PremiumMembers.premiumMembersArrayList.get(i).getPassword().equals(pass)){
//                System.out.println("Logged In");
//                return PremiumMembers.premiumMembersArrayList.get(i);
//            }
//        }
//        System.out.println("Invalid input");
//        return null;
//    }
    @Override
    public void explore_zoo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1->See Attractions\n2->See Animals");
        int choice = sc.nextInt();
        if(choice == 1){
            for(int i = 0; i< Attractions.attraction_list.size(); i++){
                System.out.println(Attractions.attraction_list.get(i).getName()+"->"+Attractions.attraction_list.get(i).getDescription());
            }
        }
        else if(choice == 2){
            System.out.println("REPTILES IN THE ZOO: ");
            for(int i = 0; i< Reptiles.reptilesArrayList.size(); i++){
                System.out.println(Reptiles.reptilesArrayList.get(i).getName());
            }
            System.out.println();
            System.out.println("MAMMALS IN THE ZOO: ");
            for(int i = 0; i< Mammals.mammalsArrayList.size(); i++){
                System.out.println(Mammals.mammalsArrayList.get(i).getName());
            }
            System.out.println();
            System.out.println("AMPHIBIANS IN THE ZOO: ");
            for(int i = 0; i< Amphibians.amphibiansArrayList.size(); i++){
                System.out.println(Amphibians.amphibiansArrayList.get(i).getName());
            }
        }
    }







    @Override
    public void visit_animals() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1->Reptiles\n2->Mammals\n3->Amphibians");
        int type = sc.nextInt();
        if(type == 1){
            Reptiles.setVisitor_at_reptiles(Reptiles.getVisitor_at_reptiles()+1);
            for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                System.out.println(Reptiles.reptilesArrayList.get(i).getReptile_ID()+"->"+Reptiles.reptilesArrayList.get(i).getName());
            }
            System.out.println("Enter animal ID");
            int id = sc.nextInt();
            System.out.println("1->Feed\n 2->Read");
            int choice = sc.nextInt();
            if(choice == 1){
                for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                    if(Reptiles.reptilesArrayList.get(i).getReptile_ID() == id){
                        Reptiles.reptilesArrayList.get(i).sound();

                    }
                }
            }
            if(choice == 2){
                for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                    if(Reptiles.reptilesArrayList.get(i).getReptile_ID() == id){
                        Reptiles.reptilesArrayList.get(i).getDescription();
                    }
                }
            }
        }
        else if(type == 2){
            Mammals.setMem_visit_mammals(Mammals.getMem_visit_mammals()+1);
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                System.out.println(Mammals.mammalsArrayList.get(i).getMammal_ID()+"->"+Mammals.mammalsArrayList.get(i).getName());
            }
            System.out.println("Enter animal ID: ");
            int id = sc.nextInt();
            Mammals temp = null;
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                if(Mammals.mammalsArrayList.get(i).getMammal_ID() == id){
                    temp = Mammals.mammalsArrayList.get(i);
                }
            }
            System.out.println("1->Feed\n 2->Read");
            int choice = sc.nextInt();
            if(choice == 1){
                temp.sound();
            }
            else if(choice == 2){
                temp.getDescription();
            }
        }
        else if(type == 3){
            Amphibians.setMem_visit_amph(Amphibians.getMem_visit_amph()+1);
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                System.out.println(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID()+"->"+Amphibians.amphibiansArrayList.get(i).getName());
            }
            System.out.println("Enter Animal ID: ");
            int id = sc.nextInt();
            Amphibians temp = null;
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                if(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID() == id){
                    temp = Amphibians.amphibiansArrayList.get(i);
                }
            }
            System.out.println("1->Feed \n 2->Read");
            int choice = sc.nextInt();
            if(choice == 1){
                temp.sound();
            }
            else if(choice == 2){
                temp.getDescription();
            }
        }
    }

    @Override
    public void visit_attractions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Below is the list of all the attractions currently open");
        for(int i = 0;i<Attractions.attraction_list.size();i++){
            if(Attractions.attraction_list.get(i).getTimings() == 1){
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Attraction ID: "+Attractions.attraction_list.get(i).getAttraction_ID());
                System.out.println("Attraction Name: "+Attractions.attraction_list.get(i).getName());
                System.out.println("Attraction Description: "+Attractions.attraction_list.get(i).getDescription());
            }
        }
        System.out.println("Choose attraction ID: ");
        int choice = sc.nextInt();
        for(int i = 0;i<Attractions.attraction_list.size();i++){
            if(Attractions.attraction_list.get(i).getAttraction_ID() == choice){
                System.out.println("Welcome to "+Attractions.attraction_list.get(i).getName());
                System.out.println("Description: "+Attractions.attraction_list.get(i).getDescription());
                Attractions.attraction_list.get(i).setUsers(Attractions.attraction_list.get(i).getUsers()+1);
                return;
            }
        }
        System.out.println("Attraction ID invalid");

    }

    @Override
    public void give_feedback(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Your feedback is valuable");
        System.out.print("Feedback-> ");
        String input = sc.nextLine();
        feedback.add(input);
        System.out.println("Feedback is recorded!");
    }
}
