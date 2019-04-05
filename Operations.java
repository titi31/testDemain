import java.util.Date;
public class Operations {
	private String Name;
	private Date DateCreation;
	private double montant;
	private  Accounts Accounts;
	public Operations() {
		this.Name="rien";
		this.DateCreation=new Date();
		this.montant=0;
	};
	public Operations(String Name,Date DateCreation,double montant,Accounts Accounts) {
		this.Name=Name;
		this.DateCreation=DateCreation;
		this.montant=montant;
		this.Accounts=Accounts;
	}
	public String toString() {
		return Name +"[ "+DateCreation+" Montant: "+montant+" Accounts: "+ Accounts.getNumCt() + " ]";
	}
}