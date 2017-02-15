package plic.tds;

public class Entree {
	private String nom;
	
	public static final int PUBLIQUE = 1, PRIVEE = 2;
	
	public static final int ENTIER = 1;
	
	public Entree(String n){
		nom=n;
	}
	
	public String getNom(){
		return nom;
	}
}
