package plic.tds;

import plic.exceptions.AnalyseSyntaxiqueException;

public class Symbole {
	private int spec;
	private Type type;
	private int depl;
	
	
	public static final int PUBLIQUE = 1, PRIVEE = 2;
	
	public static final int ENTIER = 1;
	
	//récupère le statut en format int d'une chaine
	public static int statut(String s){
		switch(s){
			case "publique":
				return PUBLIQUE;
			case "privee":
				return PRIVEE;
			default:
				throw new AnalyseSyntaxiqueException("Spécificateur d'accès attendu à la place de "+s);
		}
	}

	public Symbole(int acces, Type t){
		spec=acces;
		type=t;
		depl = Tds.getInstance().getDeplacementMemoire();
	}

	
	public int getSpec(){
		return spec;
	}
	
	public Type getType(){
		return type;
	}
	
	public int getDeplacement(){
		return depl;
	}
	
}
