public class Customers {
	private String nom;
	private String email;
	public Customers(String nom,String email) {
		this.nom=nom;
		this.email=email;
	}

	public String toString() {
		return "[nom: "+ nom + " email: "+email+" ]";
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return this.nom;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return this.email;
	}
}