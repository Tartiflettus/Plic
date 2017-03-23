package plic.arbre.instruction;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;

public class TantQue extends Instruction {
	private Expression expr;
	private BlocDInstructions bloc;

	public TantQue(int no, Expression e, BlocDInstructions b) {
		super(no);
		e = expr;
		bloc = b;
	}

	@Override
	public void verifier() {
		bloc.verifier();
	}

	@Override
	public String toMIPS() {
		return bloc.toMIPS();
	}

}
