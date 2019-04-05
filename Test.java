import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Customers c1 = new Customers("dupont","dupont@gmail.com");

		Customers c2 = new Customers("durand","durand@gmail.com");	
		
		Accounts cp1 = new CompteCourant("1",new Date(),900.0,c1,60);  // code compte + date de creation + solde + client + découvert autorisé

		Accounts cp2 = new CompteEpargne("2",new Date(),900.0,c2,5.5); // code compte + date de creation + solde + client + taux

		System.out.println(cp1) ;

		System.out.println(cp2) ;	
		IBanqueMetier banqueMetier= (IBanqueMetier) cp1;
		
		IBanqueMetier banqueMetier2= (IBanqueMetier) cp2;
		banqueMetier.consulterAccounts(cp1);

		banqueMetier2.consulterAccounts(cp2);

		banqueMetier.verser(cp1, 100);

		banqueMetier.verser(cp1, 100);
		banqueMetier.verser(cp1, 200);

		banqueMetier.retirer(cp1, 300);
		
		//banqueMetier.retirer(cp1, 900);
		//banqueMetier.retirer(cp1, 161);
	   // banqueMetier.retirer(cp1, 250);
	 //   banqueMetier.retirer(cp1, 250);
	  // banqueMetier.retirer(cp1, 61);
	  //  banqueMetier.retirer(cp1, 300);
		banqueMetier2.verser(cp2, 700);

		banqueMetier2.retirer(cp2, 300);
		banqueMetier2.retirer(cp2, 301);
		
	banqueMetier2.retirer(cp2, 300);
		//banqueMetier2.retirer(cp2, 300);
		//banqueMetier2.retirer(cp2, 300);
		banqueMetier.virement(cp1, cp2, 100);
		
		System.out.println("\nsolde de " + cp1.getCustomers().getNom()   + " : "); 
		banqueMetier.consulterAccounts(cp1);

		System.out.println("solde de "   + cp2.getCustomers().getNom()   + " : ");
		banqueMetier2.consulterAccounts(cp2);
		System.out.println("\n----------------Historique des opérations--------------------");
		System.out.println("\n"+cp1.getCustomers().getNom()+"\n");
		for(Operations op : banqueMetier.listOperations(cp1)) 	System.out.println(op);

		System.out.println("\n-----------------------------------------");
		System.out.println("\n"+cp2.getCustomers().getNom()+"\n");
		for(Operations op : banqueMetier2.listOperations(cp2))	System.out.println(op);

	}
}