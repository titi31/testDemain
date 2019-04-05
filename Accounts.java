import java.util.Date;

import co.simplon.entities.Operations;

import java.util.ArrayList;
public abstract class Accounts  {
	
	public ArrayList<Operations> listOp=new ArrayList<Operations>();
	private String NumCt;
	private Date DateCreation;
	//private double Balance;
	protected static Customers Customers;
	public Accounts() {
		
	}
	
	public Accounts(String NumCt,Date DateCreation,double Balance,Customers Customers) {
		this.NumCt=NumCt;
		this.DateCreation=DateCreation;
		//this.Balance=Balance;
		this.Customers=Customers;
	
	}
	
	public String toString() {
		return "[ NumCt: "+NumCt+" DateCreation: "+DateCreation+"Customers: "+Customers;
	}
	public void setCode(String code) {
		this.NumCt=NumCt;
	}
	public String getNumCt() {
		return this.NumCt;
	}
	public abstract void setBalance(double Balance) ;
	public abstract double getBalance() ;
	public void setCustomers(Customers Customers) {
		this.Customers=Customers;
	}
	public Customers getCustomers() {
		return Customers;
	}
	
	
	
	
	
	/*public void consulterAccounts(Accounts Accounts) {
		System.out.println("Balance: "+Accounts.getBalance());
	}
	
	public void retirer(Accounts Accounts,int argent){
		
		if(argent<400) {

			compte.setBalance(compte.getBalance()-argent);
		listOp.add(new Operations("Retrait",new Date(),argent,Accounts));
		}
		else
			System.out.println("vous ne pouvez pas retirer plus de 400 euro !");
			
		//listOp.add(retire);
	}
	public void verser(Accounts Accounts,int argent) {
		compte.setSolde(compte.getBalance()+argent);
		listOp.add(new Operation("Versement",new Date(),argent,Accounts));
		
		//listOp.add(verse);
		
	}
	public void virement(Accounts Accounts1,Accounts Accounts2,int argent) {
		double Balance1=Accounts1.getBalance()-argent;
		double Balance2=Accounts2.getBalance()+argent;
		compte1.setBalance(Balance1);
		compte2.setBalance(Balance2);
		listOp.add(new Operations("Virement",new Date(),argent,Accounts1));
		//listOp.add(virement);
		
	}
	public ArrayList<Operations> listOperations(Accounts Accounts){
	
		return listOp;
	}*/
}