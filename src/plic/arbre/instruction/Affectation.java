package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.arbre.variable.Variable;

public abstract class Affectation extends Instruction {
	protected Expression droite;
	protected Variable idf;

	public Affectation(Variable idf, Expression d) {
		super(d.getNoLigne());
		droite = d;
		this.idf = idf;
	}

}
