package co.simplon.testDao;
import co.simplon.dao.CustomersDao;
import co.simplon.entities.Customers;
public class TestDaoCustomers {
	public static void lancerTests() {
		// le principe de base d'un programme de tests, 
		// c'est qu'on doit passer par tous les chemins pour valider 
		// Comment faire ici ?
		//test faux
		CustomersDao cd = new CustomersDao();		
		Customers c1 = new Customers(3,"Teddy","Franck");	
		Customers c2 = new Customers(2,"Teddy","Franck");
		
		if(cd.create(c2))	System.out.println("insertion ok de " + c2);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Customers c3 = cd.find(c1.getIdCust()); 		
		if(c3 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c3);
		
		c1.setFirstName("Angele");
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");	
		//test vrai
		if(cd.create(c1))	System.out.println("insertion ok de " + c1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
		Customers c4 = cd.find(c1.getIdCust()); 	
		if(c4 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c4);
		c1.setFirstName("Angele");
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");	
		
}
}