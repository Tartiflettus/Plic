package plic.tds;

import java.util.HashMap;

import plic.exceptions.AnalyseSemantiqueException;

public class Tds {
	private static Tds instance = new Tds();
	private HashMap<Entree, Symbole> map;
	private int tailleZone;
	
	private static int deplMem=0;



	private Tds(){
		map=new HashMap<Entree,Symbole>();
		tailleZone=0;
	}
	
	public static Tds getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s){
		if(!map.containsKey(e)){
			map.put(e,s);
			deplMem -= 4;
		}
		else{
			throw new AnalyseSemantiqueException(0,0,"Variable " + e.getNom() + " deja declaree.");
		}
	}
	
	public Symbole identifier(Entree e){
		if(map.containsKey(e)){
			return map.get(e);
		}
		return null;
	}
	
	
	public int getDeplacementMemoire(){
		return deplMem;
	}
	
	public void EntreeBloc(){
		
	}
	
	public void SortieSortie(){
		
	}
}

