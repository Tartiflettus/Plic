package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.tds.Tdd;

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
		String res = expr.toMIPS()
				+ "move $a0, $v0\n"
				+ "li $v0, 1\n"
				+ "syscall\n";
		return res;
	}

}
