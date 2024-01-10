Owner: Vimansh Mahajan
IIIT_D Roll Number: 2022572

Assumptions in Code:
1->Modify Animal only allows modifying the description
2->Discounts are based on the age of the members.
3-> While a member buys ticket, only those discount codes will be displayed that can provide discount to that person (say a person of age 18
will only be shown discount code which lies in that age range and not for any other age range(say age 50 to 100)).

4-> Member will only be given one chance to enter correct discount coupon else payment proceeds without discount application.

5-> Deals are based on the number of tickets, and once a user gives the required amount of tickets he will purchase in one go, the deal get automatically
applied and member is notified.
6-> Initially every new member is provided with basic membership and an option to upgrade membership is provided in the menu
7-> After buying membership, every user must re-login to experience the premium feature(prompt about same given during buy_membership function)
8-> While buying tickets, members are only shown those attractions which are currently operating.
9-> While spending the ticket, if at that moment an attraction is closed a prompt about the same is given and ticket is not used.

HOME_FOLDER = A2_2022572

OOPS Concept used:
Abstract class-> To handle Basic and Premium member class
Interface-> To handle Animal classes
Object Class and its methods-> Typecasting the return type of Members to decide between basic and premium members
                                methods like .equals(), .getClass(), .toString() etc. used at a lot of places to demonstrate
                                use of Object class and its functions
Inheritance-> BasicMembers and PremiumMembers extends from their parent abstract class
Polymorphism-> Overriding of methods used at a lot of locations in Animal and Member class to demonstrate polymorphism
Getter&Setter-> To provide data security and abstraction




