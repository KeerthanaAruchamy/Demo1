package app.BankAccount;

import java.sql.Connection;
import java.sql.DriverManager;

public class Bank {

	  private String name;
	  private String address;
	  private char acc_type;
	  private float balance;
	 
	  // Constructor of class Bank
	  Bank(){
	  name=" ";
	  address=" ";
	  acc_type=' ';
	  balance=0;
	 }
	   
	// Method to open the account
	void open_account()
	{
	    name = "Adithi Rajan";
	    System.out.println("Enter your AccountHolder Name: ");
	    address = "Adithi";
	    System.out.println("Enter your address: ");    
	    acc_type = 'A';
	    System.out.println("What type of account you want");
	    System.out.println(" to open saving(S) or Current(C): ");
	    balance = 8000;
	    System.out.println("Enter How much money you want to deposit: ");
	    System.out.println("Account Created Successfully");
	}
	   
	// Method to deposit the account
	void deposit_money()
	{
	    int Amount;
	    Amount = 9500;
	    System.out.println( "Enter the Amount that you have to Deposit: "+ Amount);
	    balance += Amount;
	    System.out.println( "\n Available Balance: "+ balance);   
	}
	   
	// Method to display the account
	void display_account()
	{
	    System.out.println( "AccountHolderName: " +name);
	    System.out.println("Address: "+ address);
	    System.out.println("Type: "+acc_type);
	    System.out.println("Balance: " +balance);
	}
	   
	// Method to withdraw the account
	void withdraw_money()
	{
	    float amount;
	    amount = 3200;
	    System.out.println("Enter how much money you want to withdraw: "+amount );
	    balance -= amount;
	    System.out.println("\n Available balance: "+ balance);      
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Passw0rd");
        System.out.println("DB connected.");
        int choice;
        Bank customer=new Bank();
        System.out.println("\n1) Create account \n");     
        customer.open_account();
        System.out.println("\n*************************************\n");
        System.out.println("\n2) Deposit Amount\n");
        customer.deposit_money();
        System.out.println("\n*************************************\n");
        System.out.println("\n3) Withdraw Money \n\n");
        customer.withdraw_money();
        System.out.println("\n***************************************\n");
        System.out.println("\n4) Display Account \n\n");
        customer.display_account();
        System.out.println("\n******************************************\n"); 
     }
    catch(Exception e) {
      	 System.out.println(e.getMessage());
       }
    }
                            
    }
   
	


