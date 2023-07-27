package oasisintern;

import java.util.*;
class account{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("Enter full name :");
        ATM.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("REGISTRATION DONE.....!!!!");
        System.out.println("*******************************************");
        ATM.options();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            switch(choice){
            case 1:
            	login(user,pass);
                break;
            
            case 2:
                    System.exit(0);
                
                default:
                    System.out.println("Invalid Input....!Try again.....!");
                    break;
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdrawn successfully");
            System.out.println("*******************************************");
        }
        else{
            System.out.println("INSUFFICIENT BALANCE....!!");
            System.out.println("*******************************************");
        }
        ATM.options();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposited successfully!");
        System.out.println("*******************************************");
        ATM.options();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Receipent's Name:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the Receipent :");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("*******************************************");
        }
        else{
            System.out.println("INSUFFICIENT BALANCE....!!");
            System.out.println("*******************************************-");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("*******************************************");
        System.out.println("AVAILABLE BALANCE :");
        ATM.showbalance();
        System.out.println("*******************************************");
        ATM.options();
    }
}
class his{
    static void transactions(){
            System.out.println("*******************************************");
            System.out.println("Transaction History :");
            System.out.println("\n- - - - - - - - - - - - - - ");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("\n- - - - - - - - - - - - - - ");
            }
            }
            else {
                System.out.println("Your Account is EMPTY");
            }
            ATM.options();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void new_login(){

        Scanner sc=new Scanner(System.in);
        System.out.println("********WELCOME TO ATM INTERFACE********");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int ch =sc.nextInt();
       switch(ch){
       case 1:
                account.register();
                break;
        
       case 2:
    	   System.out.println("Thank You for visiting");
    	   System.exit(0);
       default:
                System.out.println("Select from the given options :");
                new_login();
                break;
            }
        }
    
    static void options(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name);
        System.out.println("*******************************************");
        System.out.println("Select action you want to proceed with : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int ch=sc.nextInt();
        switch (ch) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactions();
            case 6:
            	System.out.println("Thank You for visiting");
                System.exit(0);
            default:
            	System.out.println("Select from the given options :");
            	ATM.options();
        }
    }

    public static void main(String[] args) {
        new_login();
    }
}