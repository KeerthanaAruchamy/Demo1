package app.BankAccount;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
public class CreateReadUpdate {
	static Hashtable<Integer,CreateReadUpdate>ht=new Hashtable<Integer,CreateReadUpdate>();	
		LinkedList<Getsetmethod>list;
		public CreateReadUpdate() {
			list = new LinkedList<>();
		}

		public void add(Getsetmethod record) {
			// TODO Auto-generated method stub
			if(!find(Getsetmethod.getAccNumber)) {
				list.add(record);
			}
			else {
				System.out.println("****Already Entered details Exists****");
			}
		}

	boolean find(int getaccNumber) {
			// TODO Auto-generated method stub
			for(Getsetmethod l : list) {
				if(l.getAccNumber() == getaccNumber) {
					System.out.println(l);
					return true;
				}
			}
			return false;
		}

		public void delete(int rAcc) {
			// TODO Auto-generated method stub
			  Getsetmethod recordDel = null;		
		        for (Getsetmethod ll : list) {
		            if (ll.getAccNumber() == rAcc) {
		                recordDel = ll;
		            }
		        }
		        if (recordDel == null) {	 
		            System.out.println("****Account Number Invalid****");
		        }
		        else {
		 
		            list.remove(recordDel);	 
		            System.out.println("--Successfully removed record from the list");
		        }
		    }
		
		public Getsetmethod findRecord(int accNumber) {
			// TODO Auto-generated method stub      
	        for (Getsetmethod l : list) {
	 
	            // Checking record by id Number.
	            if (l.getAccNumber() == accNumber) {
	                return l;
	            }
	        }
	 
	        return null;
	    }
		
		public void update(int id, BufferedReader inp) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			if(find(id)) {
				Getsetmethod rec = findRecord(id);
				System.out.println("Enter Account Number:");
				int AccNumbr = Integer.parseInt(inp.readLine());
				System.out.println("Enter AccountBalance:");
	    		int Balance = Integer.parseInt(inp.readLine());
	    		System.out.println("Enter AccountHolderName:");
	    		String Name = inp.readLine();
	    		
	    		rec.setAccNumber(AccNumbr);
	    		rec.setName(Name);
	    		rec.setBalance(Balance);
	    		System.out.println("***Updated SuccessFully***");
			}
			else {
				System.out.println("Record Not Found in Record List");
			}
			
		}

		public void display() {
			// TODO Auto-generated method stub
			if(list.isEmpty()) {
				System.out.println("The List has no records \n");
			}
			for(Getsetmethod record:list) {
				System.out.println(record.toString());
			}
		}

}
