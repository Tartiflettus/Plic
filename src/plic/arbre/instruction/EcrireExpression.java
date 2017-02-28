package plic.arbre.instruction;

import plic.arbre.expression.Expression;

public class EcrireExpression extends Instruction {
	private Expression expr;

	public EcrireExpression(int no, Expression expr) {
		super(no);
		this.expr = expr;
	}

	@Override
	public void verifier() {
		//TODO
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
