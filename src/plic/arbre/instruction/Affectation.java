package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.arbre.expression.Variable;
import plic.tds.Entree;

public abstract class Affectation extends Instruction {
	protected Expression droite;
	protected Entree idf;

	public Affectation(Entree idf, Expression d) {
		super(d.getNoLigne());
		droite = d;
		this.idf = idf;
	}

}
