package plic.tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import plic.exceptions.AnalyseSemantiqueException;

public class Bloc {
	private String name;
	private HashMap<Entree, Symbole> map;
	private ArrayList<Bloc> fils;
	private Bloc pere;

	public Bloc(String n) {
		name = n;
		map = new HashMap<Entree, Symbole>();
		fils = new ArrayList<Bloc>();
		pere = null;
	}

	public void setPere(Bloc b){
		pere = b;
	}
	
	public Bloc getPere() {
		return pere;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean contientEntree(Entree e) {
		return map.containsKey(e);
	}

	public void verifierHashmap() {
		if (pere != null) {
			Set<Entree> cles = map.keySet();
			Iterator<Entree> it = cles.iterator();
			while (it.hasNext()) {
				Entree entree = it.next();
				if (pere.contientEntree(entree)) {
					throw new AnalyseSemantiqueException(0, 0,
							"Variable " + entree.getNom() + " deja declaree dans une classe parent.");
				}
			}
		}
	}

	public void setHashmap(HashMap<Entree, Symbole> hashmap) {
		map = hashmap;
	}

	public boolean blocExiste(String name) {
		for (Bloc b : fils) {
			if (b.getName().equals(name))
				return true;
			if (b.blocExiste(name))
				return true;
		}
		return false;
	}

	public void ajouterFils(Bloc nvBloc) {
		fils.add(nvBloc);
		nvBloc.verifierHashmap();
	}

	public void chercherHeritage(Bloc nvBloc, String heritage) {
		for (Bloc b : fils) {
			if (b.getName().equals(heritage)) {
				nvBloc.setPere(b);
				b.ajouterFils(nvBloc);
			}
			b.chercherHeritage(nvBloc, heritage);
		}
	}
}
