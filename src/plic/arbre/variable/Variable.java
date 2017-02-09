package plic.arbre.variable;

import plic.arbre.ArbreAbstrait;

public abstract class Variable extends ArbreAbstrait {
	protected String idf;
	
	public Variable(int no, String idf) {
		super(no);
		this.idf = idf;
	}

	
	public String getIdf(){
		return idf;
	}

}
