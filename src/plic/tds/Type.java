package plic.tds;

public abstract class Type {
	protected String nom;
	
	public Type(String n){
		nom=n;
	}
	
	public String toString(){
		return nom;
	}
}
