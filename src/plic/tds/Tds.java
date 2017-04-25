package plic.tds;

import java.util.ArrayList;
import java.util.HashMap;

import plic.exceptions.AnalyseSemantiqueException;

public class Tds {
	private static Tds instance = new Tds();
	private HashMap<Entree, Symbole> map;
	private int tailleZone;
	private ArrayList<Bloc> blocs;
	private Bloc blocActu;
	private String classePrincipale;

	private static int deplMem = 0;

	private Tds() {
		map = new HashMap<Entree, Symbole>();
		blocs = new ArrayList<Bloc>();
		tailleZone = 0;
	}

	public static Tds getInstance() {
		return instance;
	}

	public void ajouter(Entree e, Symbole s) {
		if (!map.containsKey(e)) {
			map.put(e, s);
			deplMem -= 4;
		} else {
			throw new AnalyseSemantiqueException(0, 0, "Variable " + e.getNom() + " deja declaree.");
		}
	}

	public Symbole identifier(Entree e) {
		if (map.containsKey(e)) {
			return map.get(e);
		}
		return null;
	}

	public int getDeplacementMemoire() {
		return deplMem;
	}

	public boolean blocExiste(String name) {
		for (Bloc b : blocs) {
			if (b.getName().equals(name))
				return true;
			if (b.blocExiste(name))
				return true;
		}
		return false;
	}

	public void chercherHeritage(Bloc nvBloc, String heritage) {
		for (Bloc b : blocs) {
			if (b.getName().equals(heritage)){
				nvBloc.setPere(b);
				b.ajouterFils(nvBloc);
			}
			b.chercherHeritage(nvBloc, heritage);
		}
	}

	public void ajouterBloc(String name, String heritage) {
		if (!blocExiste(name)) {
			Bloc b = new Bloc(name);
			b.setHashmap(map);
			map = new HashMap<Entree, Symbole>();
			blocActu = b;
			if (heritage == null) {
				blocs.add(b);
			} else {
				if (blocExiste(heritage))
					chercherHeritage(b, heritage);
				else
					throw new AnalyseSemantiqueException(0, 0, "Classe héritage" + name + " n'existe pas.");
			}
		} else
			throw new AnalyseSemantiqueException(0, 0, "Classe " + name + " deja declaree.");

	}

	public void EntreeBloc() {

	}

	public void SortieSortie() {

	}
	
	public String getClassePrincipale(){
		return classePrincipale;
	}
	
	public void setClassePrincipale(String cp){
		classePrincipale = cp;
	}
}
