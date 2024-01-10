package org.IIITD.VM.projects.Zootopia.Members;
import org.IIITD.VM.projects.Zootopia.Admin.Admin;
import org.IIITD.VM.projects.Zootopia.Animals.Amphibians;
import org.IIITD.VM.projects.Zootopia.Animals.Animal_property;
import org.IIITD.VM.projects.Zootopia.Animals.Mammals;
import org.IIITD.VM.projects.Zootopia.Animals.Reptiles;
import org.IIITD.VM.projects.Zootopia.Attractions.Attractions;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Deals;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Discount;
import org.w3c.dom.Attr;

import java.lang.reflect.Member;
import java.nio.file.attribute.DosFileAttributes;
import java.util.*;

import static java.lang.Math.ceil;

public class BasicMembers extends AbstractMembers{
    public static ArrayList<BasicMembers> basic_arraylist = new ArrayList<>();
    private ArrayList<Attractions> tickets = new ArrayList<>();
    private static ArrayList<String> feedbacks = new ArrayList<>();
    public static void feedbacks_to_string(){
        for(int i = 0;i<feedbacks.size();i++){
            System.out.println("--->"+feedbacks.get(i));
        }
    }

//    public ArrayList<Integer> getTickets() {
//        return tickets;
//    }

//    public void setTickets(Attractions a) {
//        this.tickets.add(a);
//    }

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

    public BasicMembers(String name, int age, String phone_num, int balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phone_num = phone_num;
        this.balance = balance;
        this.Email = email;
        this.password = password;
    }
    public static void register_member(){

        Scanner sc = new Scanner(System.in); // int input;
        Scanner inp = new Scanner(System.in); // String input;
        System.out.println("Name: ");
        String name = inp.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("Phone number: ");
        String ph = inp.nextLine();
        System.out.println("Balance(min 100): ");
        int bal = sc.nextInt();
        int temp = bal;
        while(true){
            if(temp>=100){
                break;
            }else{
                System.out.println("Enter valid amount!");
                temp = sc.nextInt();
            }
        }
        bal = temp;
        System.out.println("Email: ");
        String email = inp.nextLine();
        System.out.println("Password: ");
        String pass = inp.nextLine();
        BasicMembers bm1 = new BasicMembers(name,age,ph,bal,email,pass);
        BasicMembers.basic_arraylist.add(bm1);
        //System.out.println("Member registered!");
        //System.out.println("Membership active: Basic");
        int dis = 0;
        int pay = 20;
        for(int i = 0;i< Discount.discountArrayList.size();i++){
            if(Discount.discountArrayList.get(i).getLower_bound()<=age && Discount.discountArrayList.get(i).getUpper_bound()>=age){
                System.out.println("Discount available, discount code = "+Discount.discountArrayList.get(i).getDiscount_name());
                System.out.println("Enter discount code: ");
                String dis_code = inp.nextLine();
                if(dis_code.equals(Discount.discountArrayList.get(i).getDiscount_name())){
                    dis = Discount.discountArrayList.get(i).getDiscount_percentage();
                    System.out.println("Discount "+ Discount.discountArrayList.get(i).getDiscount_name()+" of "+Discount.discountArrayList.get(i).getDiscount_percentage() +"% available on membership and applied successfully");
                }
                else{
                    System.out.println("Invalid discount code applied, payment will proceed without discount");
                }
                break;
            }
        }
        pay = (int) (20 - ((20*dis)/100.0));
        System.out.println("Member registered successfully");
        System.out.println("Membership: Basic");

        Admin.setRevenue(Admin.getRevenue()+pay);
        for(int i = 0;i<BasicMembers.basic_arraylist.size();i++){
            if(BasicMembers.basic_arraylist.get(i).getEmail().equals(email)){
                BasicMembers.basic_arraylist.get(i).setBalance(BasicMembers.basic_arraylist.get(i).getBalance()-pay);
                System.out.println("Balance now: "+BasicMembers.basic_arraylist.get(i).getBalance());
            }
        }
    }
    public static AbstractMembers member_login(String mail,String password){
        //Scanner sc = new Scanner(System.in); // int input;
        //Scanner inp = new Scanner(System.in); //string input;

        String email = mail;
        String pass = password;

        for(int i = 0;i<BasicMembers.basic_arraylist.size();i++){
            if(BasicMembers.basic_arraylist.get(i).getEmail().equals(email) && BasicMembers.basic_arraylist.get(i).getPassword().equals(pass)){
                System.out.println("Logged In");
                return BasicMembers.basic_arraylist.get(i);

            }
        }
        for(int i = 0;i<PremiumMembers.premiumMembersArrayList.size();i++){
            if(PremiumMembers.premiumMembersArrayList.get(i).getEmail().equals(email) && PremiumMembers.premiumMembersArrayList.get(i).getPassword().equals(pass)){
                System.out.println("Logged in");
                return PremiumMembers.premiumMembersArrayList.get(i);
            }
        }
        System.out.println("Invalid input");
        return null;
    }

    public void see_discount(){
        for(int i = 0;i<Discount.discountArrayList.size();i++){
            System.out.println("Discount name(Coupon Code): "+Discount.discountArrayList.get(i).getDiscount_name());
            System.out.println("Discount Percentage: "+Discount.discountArrayList.get(i).getDiscount_percentage());
            System.out.println("Applicable on age range (in years): "+ Discount.discountArrayList.get(i).getLower_bound()+" to "+Discount.discountArrayList.get(i).getUpper_bound());
        }
    }

    @Override
    public void explore_zoo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1->See Attractions\n 2->See Animals");
        int choice = sc.nextInt();
        if(choice == 1){
            for(int i = 0;i< Attractions.attraction_list.size();i++){
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
    public void add_balance(int balance){
        this.balance+=balance;
    }

    public void buy_membership() {
        Scanner inp = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int dis = 0;
        int pay = 50;
        for(int i = 0;i< Discount.discountArrayList.size();i++){
            if(Discount.discountArrayList.get(i).getLower_bound()<=this.age && Discount.discountArrayList.get(i).getUpper_bound()>=this.age){
                System.out.println("Discount available, discount code = "+Discount.discountArrayList.get(i).getDiscount_name());
                String dis_code = inp.nextLine();
                if(dis_code.equals(Discount.discountArrayList.get(i).getDiscount_name())){
                    dis = Discount.discountArrayList.get(i).getDiscount_percentage();
                    System.out.println("Discount "+ Discount.discountArrayList.get(i).getDiscount_name()+" of "+Discount.discountArrayList.get(i).getDiscount_percentage() +"% available on membership and applied successfully");
                }
                pay = (int) (50 - ((50*dis)/100.0));
                break;
            }
        }
        System.out.println("Please pay "+ pay +" to purchase premium membership\nBenefits:\nFree access to all zoo animals and attractions");
        int payment = sc.nextInt();
        if(this.balance<pay){
            System.out.println("Insufficient balance");
            System.out.println("Enter amount below to recharge account then try purchasing premium");
            int recharge = sc.nextInt();
            this.add_balance(recharge);
        }
        else if(payment!=pay){
            System.out.println("Incorrect amount entered");
        }
        else{
            PremiumMembers pm1 = new PremiumMembers(this);
            PremiumMembers.premiumMembersArrayList.add(pm1);
            BasicMembers.basic_arraylist.remove(this);
            Admin.setRevenue(Admin.getRevenue()+50);
            System.out.println("Membership upgraded to premium");
            this.setBalance(this.getBalance()-pay);
            System.out.println("Balance now: "+this.getBalance());
            System.out.println("IMPORTANT-> Please login again to avail benefits");
        }
    }

    public void buy_ticket(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Attractions currently open->");
        for(int i = 0;i<Attractions.attraction_list.size();i++){
            if(Attractions.attraction_list.get(i).getTimings() == 1){
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Attraction ID: "+Attractions.attraction_list.get(i).getAttraction_ID());
                System.out.println("Attraction Name: "+Attractions.attraction_list.get(i).getName());
                System.out.println("Attraction price: "+Attractions.attraction_list.get(i).getPrice());
                System.out.println("Attraction Description: "+Attractions.attraction_list.get(i).getDescription());
                System.out.println("----------------------------------------------------------------------------");
            }

        }
        System.out.println("Enter number of tickets: ");
        int num_tickets = sc.nextInt();
        int dis = 0;
        for(int i = 0;i<Discount.discountArrayList.size();i++){
            if(Discount.discountArrayList.get(i).getLower_bound()<=age && Discount.discountArrayList.get(i).getUpper_bound()>=age){
                System.out.println("Discount available, CODE: "+Discount.discountArrayList.get(i).getDiscount_name());
                System.out.print("Enter CODE: ");
                String dis_code = inp.nextLine();
                if(dis_code.equals(Discount.discountArrayList.get(i).getDiscount_name())){
                    dis = Discount.discountArrayList.get(i).getDiscount_percentage();
                    System.out.println("Discount "+Discount.discountArrayList.get(i).getDiscount_name()+" of" +dis+"% available and will be applied automatically");
                    break;
                }
                else{
                    System.out.println("Wrong code applied,payment to proceed without discount!");
                    break;
                }
            }

        }
        int total_pay = 0;
        ArrayList<Attractions> temp = new ArrayList<>();
        for(int i = 0;i<num_tickets;i++){
            System.out.println("Enter attraction ID of the attraction: ");
            int id = sc.nextInt();
            for(int j = 0;j<Attractions.attraction_list.size();j++){
                if(Attractions.attraction_list.get(j).getAttraction_ID() == id){
                    int store = Attractions.attraction_list.get(j).getPrice() ;
                    total_pay+=  (int) (store - ((store*dis)/100.0));
                    //System.out.println("this tick price: "+total_pay); /////////////
                    temp.add(Attractions.attraction_list.get(j));
                }
            }
        }
        int deal_per = 0;
        for(int i = 0;i<Deals.dealsArrayList.size();i++){
            if(num_tickets == Deals.dealsArrayList.get(i).getNumber_of_tickets()){
                deal_per = Deals.dealsArrayList.get(i).getDiscount();
                System.out.println("Deal available on purchase of "+Deals.dealsArrayList.get(i).getNumber_of_tickets()+" tickets and applied successfully!");
            }
        }
        System.out.println("Processing payment...");
        total_pay = (int) (total_pay -  ((total_pay*deal_per)/100.0)); ///////////
        System.out.println("Payable amount: "+total_pay);
        //System.out.println(temp.size()); ////////////////////////////////////////////////////////////
        if(this.balance<total_pay){
            System.out.println("Insufficient balance! Recharge and try again");
            System.out.println("Your balance: "+this.getBalance());
        }
        else{
            this.balance-=total_pay;
            System.out.println("Tickets purchased!");
            System.out.println("Balance available now: "+this.getBalance());
            Admin.setRevenue(Admin.getRevenue()+total_pay);
            for(int i = 0;i<temp.size();i++){
                temp.get(i).setUsers(temp.get(i).getUsers()+1);
                this.tickets.add(temp.get(i)); /////////////////////////////////////////////////////////

            }
            for(int i = 0;i<tickets.size();i++){
                System.out.println(tickets.get(i).getName());
            }
        }
    }



    public void special_deals(){
        if(Deals.dealsArrayList.size() == 0){
            System.out.println("No deals at the moment");
            return;
        }
        System.out.println("Deals available->");
        for(int i = 0;i<Deals.dealsArrayList.size();i++){
            System.out.println("Number of tickets->"+Deals.dealsArrayList.get(i).getNumber_of_tickets());
            System.out.println("Discount percentage->"+Deals.dealsArrayList.get(i).getDiscount());
        }
    }

    @Override
    public void visit_animals() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1->Reptiles\n 2->Mammals\n 3->Amphibians");
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
                temp.description();
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
        System.out.println("The Attraction IDs for the purchased tickets are given below");
        for(int i = 0;i<this.tickets.size();i++){
            System.out.println("Attraction ID->"+this.tickets.get(i).getAttraction_ID());
        }
        System.out.println("Choose attraction you want to visit");
        int choose = sc.nextInt();
        for(int i = 0;i<tickets.size();i++){
            if(choose == tickets.get(i).getAttraction_ID() && tickets.get(i).getTimings()==1){
                System.out.println("Welcome to "+tickets.get(i).getName()+", have fun!");
                System.out.println("Description: "+tickets.get(i).getDescription());
                tickets.remove(tickets.get(i));
                for(int j = 0;j<Attractions.attraction_list.size();j++){
                    if(choose == Attractions.attraction_list.get(j).getAttraction_ID()){
                        Attractions.attraction_list.get(j).setUsers(Attractions.attraction_list.get(j).getUsers()+1);
                    }
                }
                return;
            }
        }
        System.out.println("Attraction closed or entered invalid ID");
    }

    @Override
    public void give_feedback() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your feedback matters!");
        String feedback = sc.nextLine();
        BasicMembers.feedbacks.add(feedback);
        System.out.println("Thank you for your valuable feedback!");
    }
    public void recharge_my_account(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to recharge your account!");
        int amount = sc.nextInt();
        this.balance+=amount;
        System.out.println("account recharged, balance now: "+this.getBalance());
    }
}
