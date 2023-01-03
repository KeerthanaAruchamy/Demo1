package app.BankAccount;

public class Getsetmethod {
	public static int getAccNumber;
	private String name;
	private int AccNumber;
	private int balance;
	
	public Getsetmethod(String name, int accNumber, int balance) {
		super();
		this.name = name;
		AccNumber = accNumber;
		this.balance = balance;
	}

	public Getsetmethod() {
		//default
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(int accNumber) {
		AccNumber = accNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override 
	public String toString()
    {
        return "Records{" + "Name=" + name + ", AccountNumber=" + AccNumber+ ", Balance=" + balance + '}';
    }

}
