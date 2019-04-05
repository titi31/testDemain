import java.util.ArrayList;
import co.simplon.entities.*;
public interface IBanqueMetier {
	public void consulterAccounts(Accounts Accounts);
	public void retirer(Accounts Accounts,int argent);
	public void verser(Accounts Accounts,int argent);
	public void virement(Accounts Accounts1,Accounts Accounts2,int argent);
	public ArrayList<Operations> listOperations(Accounts Accounts);
	//public void Accounts1(Accounts cp1);
	//public void Accounts(Accounts cp1);
}