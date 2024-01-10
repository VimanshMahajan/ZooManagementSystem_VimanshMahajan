package org.IIITD.VM.projects.Zootopia;

import com.sun.security.jgss.GSSUtil;
import org.IIITD.VM.projects.Zootopia.Admin.Admin;
import org.IIITD.VM.projects.Zootopia.Animals.Amphibians;
import org.IIITD.VM.projects.Zootopia.Animals.Mammals;
import org.IIITD.VM.projects.Zootopia.Animals.Reptiles;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Deals;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Discount;
import org.IIITD.VM.projects.Zootopia.Members.AbstractMembers;
import org.IIITD.VM.projects.Zootopia.Members.BasicMembers;
import org.IIITD.VM.projects.Zootopia.Members.PremiumMembers;

import java.util.Scanner;
//rev most pop attr   get visitor account
public class Main {
    public static void main(String[] args) {
            Admin admin = new Admin();
            BasicMembers basicMembers = null;
            PremiumMembers premiumMember = null;
            boolean flag = false;

            Reptiles r1 = new Reptiles("Snake","Hiss", "Snake is a reptile, Titanoboa was the largest snake to live on Earth");
            Reptiles r2 = new Reptiles("Lizard","shush","Lizard is a reptile, different types of lizards are found on Earth");
            Reptiles.reptilesArrayList.add(r1);
            Reptiles.reptilesArrayList.add(r2);

            Mammals m1 = new Mammals("Monkey","Khee-Khee","Monkeys are mammals");
            Mammals m2 = new Mammals("Elephant", "ouuuuu","Elephants are mammals");
            Mammals.mammalsArrayList.add(m1);
            Mammals.mammalsArrayList.add(m2);

            Amphibians a1 = new Amphibians("Frog","Gutar-Gutar","Frog is an amphibian");
            Amphibians a2 = new Amphibians("Salamander","salamander noise","Salamander is an amphibian");
            Amphibians.amphibiansArrayList.add(a1);
            Amphibians.amphibiansArrayList.add(a2);

            Discount d1 = new Discount(0,18,20,"Minor20");
            Discount d2 = new Discount(70,100,30,"Senior30");
            Discount.discountArrayList.add(d1);
            Discount.discountArrayList.add(d2);

            Deals dl1 = new Deals(2,20,"Fun_duo");
            Deals dl2 = new Deals(3,30,"Fun_trio");
            Deals.dealsArrayList.add(dl1);
            Deals.dealsArrayList.add(dl2);



            //BasicMembers basicMember = null;
            while(true){
                System.out.println("Welcome to ZOOTOPIA");
                System.out.println("----------------------------------");
                System.out.println("1. Enter as Admin");
                System.out.println("2. New Member");
                System.out.println("3. Enter as Member");
                System.out.println("4. Exit");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                System.out.println();
                switch (choice){
                    case 1:
                        flag = Admin.enter_as_admin();
                        if(!flag){
                            System.out.println("Wrong Credentials");
                        }
                        break;

                    case 2:
                        System.out.println("New Member registration");
                        BasicMembers.register_member();
                        break;
                    case 3:
                        Scanner input = new Scanner(System.in);
                        System.out.println("Enter your email");
                        String email = input.nextLine();
                        System.out.println("Enter your password");
                        String pass = input.nextLine();
                        AbstractMembers temp = BasicMembers.member_login(email,pass);
                        if(temp == null){
                            System.out.println("Member not found");
                        }
                        else if(temp.getClass().equals(BasicMembers.class)){
                            basicMembers = (BasicMembers) temp;
                            premiumMember = null;
                        }
                        else if(temp.getClass().equals(PremiumMembers.class)){
                            premiumMember = (PremiumMembers) temp;
                            basicMembers = null;
                        }
                    case 4:
                        break;
                }
                if(choice == 4){
                    break;
                }

                if(choice == 1 && flag){
                    while(true){
                        Scanner adm_inp = new Scanner(System.in);
                        System.out.println("1. Manage Attractions");
                        System.out.println("2. Manage Animals");
                        System.out.println("3. Set Discount");
                        System.out.println("4. Set deal");
                        System.out.println("5. View Visitor Stats");
                        System.out.println("6. View Feedback");
                        System.out.println("7. Logout");
                        System.out.println();
                        System.out.println("Enter your choice: ");
                        int c = adm_inp.nextInt();
                        switch (c){
                            case 1:
                                admin.all_attraction();
                                break;
                            case 2:
                                admin.all_animals();
                                break;
                            case 3:
                                admin.all_discount();
                                break;
                            case 4:
                                admin.all_deals();
                                break;
                            case 5:
                                admin.stats_for_zoo();
                                break;
                            case 6:
                                admin.check_feedback();
                                break;
                            case 7:
                                break;
                        }
                        if(c == 7){
                            break;
                        }
                    }
                }
                else if(choice == 3 && basicMembers!= null){
                    Scanner basic_inp = new Scanner(System.in);
                    while(true){
                        System.out.println("1. Explore the zoo");
                        System.out.println("2. Buy Membership");
                        System.out.println("3. Buy Ticket");
                        System.out.println("4. View Discount");
                        System.out.println("5. View Special Deals");
                        System.out.println("6. Visit Animals");
                        System.out.println("7. Visit Attractions");
                        System.out.println("8. Leave Feedback");
                        System.out.println("9. Recharge account");
                        System.out.println("10. Logout");
                        System.out.println();
                        System.out.println("Enter your choice");
                        int bmi = basic_inp.nextInt();
                        switch (bmi){
                            case 1:
                                basicMembers.explore_zoo();
                                break;
                            case 2:
                                basicMembers.buy_membership();
                                break;
                            case 3:
                                basicMembers.buy_ticket();
                                break;
                            case 4:
                                basicMembers.see_discount();
                                break;
                            case 5:
                                basicMembers.special_deals();
                                break;
                            case 6:
                                basicMembers.visit_animals();
                                break;
                            case 7:
                                basicMembers.visit_attractions();
                                break;
                            case 8:
                                basicMembers.give_feedback();
                                break;
                            case 9:
                                basicMembers.recharge_my_account();
                                break;
                        }
                        if(bmi == 10){
                            break;
                        }
                    }
                }
                else if(choice == 3 && premiumMember!=null){
                    Scanner prem_inp = new Scanner(System.in);
                    while(true){
                        System.out.println("1. Explore Zoo");
                        System.out.println("2. Visit Animals");
                        System.out.println("3. Visit Attractions");
                        System.out.println("4. Give Feedback");
                        System.out.println("5. Logout");
                        System.out.println();
                        System.out.println("Enter your choice: ");
                        int pmi = prem_inp.nextInt();
                        switch (pmi){
                            case 1:
                                premiumMember.explore_zoo();
                                break;
                            case 2:
                                premiumMember.visit_animals();
                                break;
                            case 3:
                                premiumMember.visit_attractions();
                                break;
                            case 4:
                                premiumMember.give_feedback();
                                break;
                            case 5:
                                break;
                        }
                        if(pmi == 5){
                            break;
                        }
                    }
                }
                else if(choice == 4){
                    break;
                }
            }
    }
}
