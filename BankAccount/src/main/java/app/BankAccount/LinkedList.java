package app.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class LinkedList {
	private static final int opt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
    	Statement stmt;
    	int rows;
    	int AccNumber;
    	String Name;
    	int Balance = 0;
    	int Amount;
    	CreateReadUpdate acc = new  CreateReadUpdate();
        Getsetmethod record = new Getsetmethod();
        
        record.setAccNumber(1234567890);
        record.setBalance(20000);
        record.setName("Kirti");   
        acc.add(record);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Passw0rd");
	         System.out.println("DB connected.");
	         BufferedReader acc1 = new BufferedReader (new InputStreamReader(System.in));
			 String user, pwd;
			 System.out.println("Enter UserName:");
			 user = acc1.readLine();
			 System.out.println("Enter Password:");
			 pwd = acc1.readLine();
			 switch(user) {
		        case"SeniorBranchManager":
		            if("TwelveEleven".equals(pwd)) {
		                System.out.println("Senior BranchManager");
		                System.err.println("Access!(4)");
		                break;
		            }
		            else {
		                System.err.println("Access Denied!");
		                System.exit(0);
		            }
		        case"Administrator":
		            if("TwelveSixteen".equals(pwd)) {
		                System.out.println("Administrator");
		                System.err.println("Limited Access!(5)");
		                break;
		            }
		            else {
		                System.err.println("Access Denied");
		                System.exit(0);
		            }           
			 }
		       
	         System.out.println("*****xyz Bank******");
	 		System.out.println("1 --Create Account");
	 		System.out.println("2 --Delete Account");
	 		System.out.println("3 --Update Account ");
	 		System.out.println("4 --Search a Account");
	 		System.out.println("5 --Display a Account");
	 		System.out.println("6 --Desposit a Amount");
	 		System.out.println("9 --Exit a program");
	 		System.out.println("Select the option that you want to perform:");
	         BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
	         do {
	         	int opt1 = Integer.parseInt(inp.readLine());
	         	String str = inp.readLine();
	         	switch (opt1) {
	         	case 1:
	         		System.out.println("Enter AccountNumber:");
	         		AccNumber = Integer.parseInt(inp.readLine());
	         		System.out.println("Enter AccountBalance:");
	         		Balance = Integer.parseInt(inp.readLine());
	         		System.out.println("Enter AccountHolderName:");
	         		Name = inp.readLine();
	             	 pstmt = con.prepareStatement("insert into Bank values(?,?,?)");
	             	 pstmt.setInt(1, AccNumber);
	             	 pstmt.setInt(2, Balance);
	             	 pstmt.setString(3, Name);
	             	 rows = pstmt.executeUpdate();
	             	 System.out.println(rows + " Account was Create(d) Successfully!!!");
	             	 break;
	         	case 2:
	         		System.out.println("Enter AccountNumber:");
	         		int rId = Integer.parseInt(inp.readLine());
	         		 pstmt = con.prepareStatement("delete from Bank where id=?");
	            	 pstmt.setInt(1, rId);
	            	 rows = pstmt.executeUpdate();
	            	 System.out.println(rows + "Account was Delete(d) Successfully!!!.");
	            	 break;
	         		
	         	case 3:
	         		System.out.println("EnterAccountNumber:");
	         		int rIdNo = Integer.parseInt(inp.readLine());
	         		pstmt = con.prepareStatement("update person set age=? where id=?");
	           	 pstmt.setInt(1, rIdNo);
	           	 rows = pstmt.executeUpdate();
	           	 System.out.println(rows + "Account was Update(d) SuccessFully.");
	         		break;
	         
	         	case 6:
	         		System.out.println("Enter AccountNumber:");
	         		AccNumber = Integer.parseInt(inp.readLine());
	         		System.out.println("Enter the Amount that you want to Deposit:");
	         		Amount = Integer.parseInt(inp.readLine());
	         		Balance += Amount;
	         		pstmt = con.prepareStatement("update bank set balance=? where amount=?");
		           	 pstmt.setInt(1, AccNumber);
		           	 pstmt.setInt(2, Amount);
		           	 rows = pstmt.executeUpdate();
		           	 System.out.println(rows + "Account was Deposited SuccessFully.");
		
	         		
	         	case 9:
	         		System.out.println("Thank you for using the application!!");
	         		System.exit(0);
	         		break;
	         		
	         	default:
	         		System.out.println("----Invalid Input----\n");
	         		break;
	         	}
	     	}
	         
	         while(opt != 9);
	     }
		catch(Exception e) {
	    	 System.out.println(e.getMessage());
	     }

		}
}
 






