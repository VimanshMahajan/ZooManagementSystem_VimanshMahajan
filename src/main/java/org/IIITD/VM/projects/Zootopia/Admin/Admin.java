package org.IIITD.VM.projects.Zootopia.Admin;
import org.IIITD.VM.projects.Zootopia.Animals.Amphibians;
import org.IIITD.VM.projects.Zootopia.Animals.Mammals;
import org.IIITD.VM.projects.Zootopia.Animals.Reptiles;
import org.IIITD.VM.projects.Zootopia.Attractions.Attractions;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Deals;
import org.IIITD.VM.projects.Zootopia.Deals_and_Discounts.Discount;
import org.IIITD.VM.projects.Zootopia.Members.BasicMembers;
import org.IIITD.VM.projects.Zootopia.Members.PremiumMembers;
import org.w3c.dom.Attr;

import java.util.*;

import static org.IIITD.VM.projects.Zootopia.Attractions.Attractions.attraction_list;


public class Admin {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static int revenue;

    public static int getRevenue() {
        return revenue;
    }

    public static void setRevenue(int revenue) {
        Admin.revenue = revenue;
    }

    public Admin() {
    }

    public static boolean enter_as_admin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username:\n");
        String user = sc.nextLine();
        System.out.println("Enter password:\n");
        String pass = sc.nextLine();
        return user.equals(ADMIN_USERNAME) && pass.equals(ADMIN_PASSWORD);
    }
    public void add_attractions(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter name of attraction: ");
        String name = sc.nextLine();
        System.out.println("Enter Price of attraction: ");
        int price = sc.nextInt();
        System.out.println("Is attraction now working? (Enter 0 for closed and 1 for working)");
        int time = sc.nextInt();
        System.out.println("Enter description: ");
        String descript = inp.nextLine();
        Attractions a1 = new Attractions(name,price,time,descript);
        attraction_list.add(a1);

        System.out.println("Attraction added successfully\n"+"Attraction name: "+a1.getName()+"    Attraction ID: "+a1.getAttraction_ID());

    }
    public void view_attractions(){
        System.out.println("______________________________________________________________");
        for(int i = 0;i<attraction_list.size();i++){
            System.out.println("Attraction's name: "+attraction_list.get(i).getName());
            System.out.println("Attraction's ID: "+attraction_list.get(i).getAttraction_ID());
            System.out.println("Attraction's description: "+attraction_list.get(i).getDescription());
            System.out.println("Attraction's price: "+attraction_list.get(i).getPrice());
            System.out.println("Attraction's status(1 for open, 0 for closed): "+attraction_list.get(i).getTimings());
            System.out.println();
        }
        System.out.println("______________________________________________________________");
    }
    public void remove_attraction(){
        for(int i = 0;i<attraction_list.size();i++){
            System.out.println("Attraction's name: "+attraction_list.get(i).getName());
            System.out.println("Attraction's ID: "+attraction_list.get(i).getAttraction_ID());
            System.out.println("Attraction's description: "+attraction_list.get(i).getDescription());
            System.out.println("Attraction's price: "+attraction_list.get(i).getPrice());
            System.out.println("Attraction's status(1 for open, 0 for closed): "+attraction_list.get(i).getTimings());
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter attraction ID to be removed: ");
        int id = sc.nextInt();
        int flag = 0;
        for(int i = 0;i<attraction_list.size();i++){
            if(attraction_list.get(i).getAttraction_ID() == id){
                attraction_list.remove(i);
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("ID not found");
        }
        else {
            System.out.println("Attraction removed successfully");
        }
    }
    public void modify_attraction(){
        for(int i = 0;i<attraction_list.size();i++){
            System.out.println("Attraction's name: "+attraction_list.get(i).getName());
            System.out.println("Attraction's ID: "+attraction_list.get(i).getAttraction_ID());
            System.out.println("Attraction's description: "+attraction_list.get(i).getDescription());
            System.out.println("Attraction's price: "+attraction_list.get(i).getPrice());
            System.out.println("Attraction's status(1 for open, 0 for closed): "+attraction_list.get(i).getTimings());
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Attraction's ID to be modified: ");
        int id = sc.nextInt();
        int flag = 0;
        for(int i = 0;i<attraction_list.size();i++){
            if(attraction_list.get(i).getAttraction_ID() == id){
                System.out.println("Enter new name for the attraction(if no change enter old name): ");
                String name = inp.nextLine();
                System.out.println("Enter working status (0 if closed and 1 if working): ");
                int status = sc.nextInt();
                System.out.println("Enter cost of the attraction: ");
                int cost = sc.nextInt();
                System.out.println("New description: ");
                String des = inp.nextLine();
                attraction_list.get(i).setDescription(des);
                attraction_list.get(i).setName(name);
                attraction_list.get(i).setPrice(cost);
                attraction_list.get(i).setTimings(status);
                System.out.println("Attraction information updated successfully");
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("ID NOT FOUND.");
        }
    }

    public void add_animal(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter type of animal : \n 1-> add mammal\n2-> add amphibian\n3-> add reptile");
        int type = sc.nextInt();
        System.out.println("Name: ");
        String name = inp.nextLine();
        System.out.println("Sound: ");
        String sound = inp.nextLine();
        System.out.println("Description: ");
        String des = inp.nextLine();
        if(type == 1){
            Mammals m1 = new Mammals(name,sound,des);
            Mammals.mammalsArrayList.add(m1);
            System.out.println("Mammal added: "+m1.getName());
            Mammals.setTotal(Mammals.getTotal()+1);
        }
        else if(type == 2){
            Amphibians a1 = new Amphibians(name,sound,des);
            Amphibians.amphibiansArrayList.add(a1);
            System.out.println("Amphibian added: "+a1.getName());
            Amphibians.setTotal(Amphibians.getTotal()+1);
        }
        else if(type == 3){
            Reptiles r1 = new Reptiles(name,sound,des);
            Reptiles.reptilesArrayList.add(r1);
            System.out.println("Reptile added: "+r1.getName());
            Reptiles.setTotal(Reptiles.getTotal()+1);
        }
        else{
            System.out.println("Enter correct type!");
        }

    }
    public void view_animal(){
        System.out.println("REPTILES IN THE ZOO: ");
        for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
            System.out.println(Reptiles.reptilesArrayList.get(i).getName());
        }
        System.out.println("MAMMALS IN THE ZOO: ");
        for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
            System.out.println(Mammals.mammalsArrayList.get(i).getName());
        }
        System.out.println("AMPHIBIANS IN THE ZOO: ");
        for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
            System.out.println(Amphibians.amphibiansArrayList.get(i).getName());
        }

    }

    public void remove_animal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the category\n 1->Reptile\n2->Mammal\n3->Amphibian");
        int type = sc.nextInt();
        if(type == 1){
            for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                System.out.println(Reptiles.reptilesArrayList.get(i).getReptile_ID() +"->"+Reptiles.reptilesArrayList.get(i).getName());
            }
            System.out.println("Enter Reptile ID to be removed: ");
            int rept_id = sc.nextInt();
            //System.out.println(Reptiles.getTotal());
            for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                if(Reptiles.reptilesArrayList.get(i).getReptile_ID() == rept_id && Reptiles.reptilesArrayList.size()>2){
                    Reptiles.reptilesArrayList.remove(i);
                    System.out.println("Animal removed");
                    return;
                }
            }
            System.out.println("Animal cannot be removed(Either animals<=2 or invalid ID)");
        }
        else if(type == 2){
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                System.out.println(Mammals.mammalsArrayList.get(i).getMammal_ID() +"->"+Mammals.mammalsArrayList.get(i).getName());
            }
            System.out.println("Enter Mammal ID to be removed: ");
            int mam_id = sc.nextInt();
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                if(Mammals.mammalsArrayList.get(i).getMammal_ID() == mam_id && Mammals.mammalsArrayList.size()>2){
                    Mammals.mammalsArrayList.remove(i);
                    System.out.println("Animal removed");
                    return;
                }
            }
            System.out.println("Animal cannot be removed(Either animals<=2 or invalid ID)");
        }
        else if(type == 3){
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                System.out.println(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID() +"->"+Amphibians.amphibiansArrayList.get(i).getName());
            }
            System.out.println("Enter Amphibian ID to be removed: ");
            int amph_id = sc.nextInt();
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                if(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID() == amph_id && Amphibians.amphibiansArrayList.size()>2){
                    Amphibians.amphibiansArrayList.remove(i);
                    System.out.println("Animal removed");
                    return;
                }
            }
            System.out.println("Animal cannot be removed(Either animals<=2 or invalid ID");
        }
        else{
            System.out.println("Invalid type");
        }
    }

    public void modify_animal(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the category\n 1->Reptile\n2->Mammal\n3->Amphibian");
        int type = sc.nextInt();
        if(type == 1){
            for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                System.out.println(Reptiles.reptilesArrayList.get(i).getReptile_ID() +"->"+Reptiles.reptilesArrayList.get(i).getName());
            }
            System.out.println("Enter Reptile ID to update description: ");
            int rept_id = sc.nextInt();
            System.out.println("Enter description: ");
            String des = inp.nextLine();
            for(int i = 0;i<Reptiles.reptilesArrayList.size();i++){
                if(Reptiles.reptilesArrayList.get(i).getReptile_ID() == rept_id){
                    Reptiles.reptilesArrayList.get(i).setDescription(des);
                }
            }
            System.out.println("Description updated");
        }
        else if(type == 2){
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                System.out.println(Mammals.mammalsArrayList.get(i).getMammal_ID() +"->"+Mammals.mammalsArrayList.get(i).getName());
            }
            System.out.println("Enter Mammal ID to update description: ");
            int mam_id = sc.nextInt();
            System.out.println("Enter description: ");
            String des = inp.nextLine();
            for(int i = 0;i<Mammals.mammalsArrayList.size();i++){
                if(Mammals.mammalsArrayList.get(i).getMammal_ID() == mam_id){
                    Mammals.mammalsArrayList.get(i).setDescription(des);
                }
            }
            System.out.println("Description updated");
        }
        else if(type == 3){
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                System.out.println(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID() +"->"+Reptiles.reptilesArrayList.get(i).getName());
            }
            System.out.println("Enter Amphibian ID to update description: ");
            int amph_id = sc.nextInt();
            System.out.println("Enter description: ");
            String des = inp.nextLine();
            for(int i = 0;i<Amphibians.amphibiansArrayList.size();i++){
                if(Amphibians.amphibiansArrayList.get(i).getAmphibian_ID() == amph_id){
                    Amphibians.amphibiansArrayList.get(i).setDescription(des);
                }
            }
            System.out.println("Description updated");
        }
    }

    public void set_discount(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter lower bound of age to apply discount: ");
        int lower = sc.nextInt();
        System.out.println("Enter upper bound of age to apply discount: ");
        int upper = sc.nextInt();
        System.out.println("Enter discount percentage(Only type the integer part of percentage without % sign): ");
        int per = sc.nextInt();
        System.out.println("Enter discount name: ");
        String name = inp.nextLine();
        Discount d1 = new Discount(lower,upper,per,name);
        Discount.discountArrayList.add(d1);
        System.out.println("Discount added!");
    }
    public void set_deals(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter number of tickets: ");
        int num = sc.nextInt();
        System.out.println("Enter discount percentage(Only add integer value and not % sign)");
        int dis = sc.nextInt();
        System.out.println("Enter name of deal: ");
        String name = inp.nextLine();
        Deals deal1 = new Deals(num,dis,name);
        Deals.dealsArrayList.add(deal1);
        System.out.println("Deal added successfully");
    }
    public void revenue_generated(){
        System.out.println("Revenue generated = "+Admin.getRevenue());
    }

    public void remove_discount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Discount name you want to remove: ");
        String name = sc.nextLine();
        for(int i = 0;i<Discount.discountArrayList.size();i++){
            if(Discount.discountArrayList.get(i).getDiscount_name().equals(name)){
                Discount.discountArrayList.remove(i);
                System.out.println("Discount removed successfully!");
                return;
            }
        }
        System.out.println("No such discount active, try again!");
    }
    public void modify_discount(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        for(int i = 0;i<Discount.discountArrayList.size();i++){
            System.out.println("Discount name(Coupon Code): "+Discount.discountArrayList.get(i).getDiscount_name());
            System.out.println("Discount Percentage: "+Discount.discountArrayList.get(i).getDiscount_percentage());
            System.out.println("Applicable on age range (in years): "+ Discount.discountArrayList.get(i).getLower_bound()+" to "+Discount.discountArrayList.get(i).getUpper_bound());
        }
        System.out.println("Enter discount name to be modified: ");
        String name = sc.nextLine();
        for(int i = 0;i<Discount.discountArrayList.size();i++){
            if(Discount.discountArrayList.get(i).getDiscount_name().equals(name)){
                System.out.println("Enter new discount percentage: ");
                int dis = inp.nextInt();
                Discount.discountArrayList.get(i).setDiscount_percentage(dis);
                System.out.println("Discount updated successfully!");
                return;
            }
        }
        System.out.println("No such discount name");
    }
    public void remove_deal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the deal to be removed (provide name): ");
        String num = sc.nextLine();
        for(int i = 0;i<Deals.dealsArrayList.size();i++){
            if(Deals.dealsArrayList.get(i).getDeal_name().equals(num)){
                Deals.dealsArrayList.remove(i);
                System.out.println("Deal removed successfully!");
                return;
            }
        }
        System.out.println("No such deal found, try again!");
    }
    public void modify_deal(){
        Scanner sc = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        for(int i = 0;i<Deals.dealsArrayList.size();i++){
            System.out.println(Deals.dealsArrayList.get(i).getDeal_name());
            System.out.println(Deals.dealsArrayList.get(i).getDiscount());
        }
        System.out.println("Enter deal name you want to update");
        String name = sc.nextLine();
        for(int i = 0;i<Deals.dealsArrayList.size();i++){
            if(Deals.dealsArrayList.get(i).getDeal_name().equals(name)){
                System.out.println("Enter new discount percentage: ");
                int dis = inp.nextInt();
                Deals.dealsArrayList.get(i).setDiscount(dis);
                System.out.println("Deal updated successfully!");
                return;
            }
        }
        System.out.println("Wrong input, try again!");
    }

    public void check_feedback(){
        BasicMembers.feedbacks_to_string();
        PremiumMembers.feedback_to_string();
    }
    public void most_famous_attraction(){
        int highest = 0;
        String attraction = " ";
        for(int i = 0;i< attraction_list.size();i++){
            if(attraction_list.get(i).getUsers()>highest){
                highest = attraction_list.get(i).getUsers();
                attraction = attraction_list.get(i).getName();
            }
        }
        System.out.println("Most famous attraction: "+attraction);

    }
    public void total_visitors(){
        int total = 0;
        for(int i = 0;i< attraction_list.size();i++){
            total+= attraction_list.get(i).getUsers();
        }
        total+= Amphibians.getMem_visit_amph();
        total+= Mammals.getMem_visit_mammals();
        total+=Reptiles.getVisitor_at_reptiles();
        System.out.println("Total visitors: "+total);
    }

    public void visitor_at_attraction(){
        int total = 0;
        for(int i = 0;i< attraction_list.size();i++){
            total+= attraction_list.get(i).getUsers();
        }
        System.out.println("Total visitors at attraction: "+total);
    }
    public void visitor_at_animals(){
        int total = 0;
        total+= Amphibians.getMem_visit_amph();
        total+= Mammals.getMem_visit_mammals();
        total+=Reptiles.getVisitor_at_reptiles();
        System.out.println("Total vistors at the ZOO: "+total);
    }
    public void stats_for_zoo(){
        visitor_at_attraction();
        visitor_at_animals();
        total_visitors();
        most_famous_attraction();
        revenue_generated();
    }

    public void all_attraction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Attraction");
        System.out.println("2. View Attraction");
        System.out.println("3. Remove Attraction");
        System.out.println("4. Modify Attraction");
        System.out.println();
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                this.add_attractions();
                break;
            case 2:
                this.view_attractions();
                break;
            case 3:
                this.remove_attraction();
                break;
            case 4:
                this.modify_attraction();
                break;
            default:
                System.out.println("Invalid option selected");
        }
    }
    public void all_animals(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Animal");
        System.out.println("2. View Animal");
        System.out.println("3. Remove Animal");
        System.out.println("4. Modify Animal Description");
        System.out.println();
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                this.add_animal();
                break;
            case 2:
                this.view_animal();
                break;
            case 3:
                this.remove_animal();
                break;
            case 4:
                this.modify_animal();
                break;
            default:
                System.out.println("Invalid choice entered");
        }
    }
    public void all_discount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Discount");
        System.out.println("2. Remove Discount");
        System.out.println("3. Modify discount");
        System.out.println();
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                this.set_discount();
                break;
            case 2:
                this.remove_discount();
                break;
            case 3:
                this.modify_discount();
                break;
            default:
                System.out.println("Wrong option selected");
        }
    }
    public void all_deals(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Deal");
        System.out.println("2. Remove Deal");
        System.out.println("3. Modify deal");
        System.out.println();
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                this.set_deals();
                break;
            case 2:
                this.remove_deal();
                break;
            case 3:
                this.modify_deal();
                break;
            default:
                System.out.println("Wrong option selected");
        }
    }





}
