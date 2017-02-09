package plic.arbre.variable;

import plic.arbre.ArbreAbstrait;
import plic.tds.Entree;

public abstract class Variable extends ArbreAbstrait {
	protected Entree idf;
	
	public Variable(int no, Entree idf) {
		super(no);
		this.idf = idf;
	}

	
	public Entree getIdf(){
		return idf;
	}

}
