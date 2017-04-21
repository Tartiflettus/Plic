package plic.arbre.classe;

import plic.arbre.ArbreAbstrait;
import plic.arbre.BlocDInstructions;
import plic.tds.Entree;

public class Constructeur extends ArbreAbstrait {
	private Entree e;
	private BlocDInstructions bloc;
	
	
	protected Constructeur(int no, Entree e, BlocDInstructions bloc) {
		super(no);
		this.e = e;
		this.bloc = bloc;
	}


	@Override
	public void verifier() {
		bloc.verifier();
	}

	@Override
	public String toMIPS() {
		//label du constructeur + bloc effectif
		return e.getNom() + ":\n" + bloc.toMIPS();
	}

}
