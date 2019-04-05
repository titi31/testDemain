package co.simplon.testDao;
import co.simplon.dao.OperationDao;
import co.simplon.entities.Operations;

public class TestDaoOperations {
	public static void lancerTests() {
		// le principe de base d'un programme de tests, 
		// c'est qu'on doit passer par tous les chemins pour valider 
		// Comment faire ici ?
		
		OperationDao cd = new OperationDao();		
				
		Operations c1 = new Operations(9,200,1);
		
		if(cd.create(c1))	System.out.println("insertion ok de " + c1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Operations c2 = cd.find(c1.getNumOp()); 		
		if(c2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c2);
		
		c1.setAmount(500);
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");
		//test faux
		Operations c3=new Operations(5,234,233);
		
		if(cd.create(c3))	System.out.println("insertion ok de " + c3);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
		c3.setNumOp(23);
		Operations c4=cd.find(c3.getNumCt());
		if(c4 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c4);
		
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");
		
		
}
}
