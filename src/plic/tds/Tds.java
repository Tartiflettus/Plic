package plic.tds;

import java.util.HashMap;

import plic.exceptions.AnalyseSemantiqueException;

public class Tds {
	private Tds instance = new Tds();
	private HashMap<Entree, Symbole> map;
	private int tailleZone;


	private Tds(){
		map=new HashMap<Entree,Symbole>();
		tailleZone=0;
	}
	
	public Tds getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s){
		if(!map.containsKey(e)){
			map.put(e,s);
		}
		else{
			throw new AnalyseSemantiqueException(0,0,"Variable " + e.getNom() + " deja declaree.");
		}
	}
	
	public Symbole identifier(Entree e){
		if(map.containsKey(e)){
			return map.get(e);
		}
		else{
			throw new AnalyseSemantiqueException(0,0,"Variable " + e.getNom() + " non déclarée.");
		}
	}
	
	public void EntreeBloc(){
		
	}
	
	public void SortieSortie(){
		
	}
}

