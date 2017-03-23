package plic.arbre.instruction;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;

public class Si extends Instruction {
	protected Expression expr;
	protected BlocDInstructions blocSi;
	protected BlocDInstructions blocSinon;
	
	public Si(Expression e, BlocDInstructions b1, BlocDInstructions b2) {
		super(e.getNoLigne());
		expr=e;
		blocSi=b1;
		blocSinon=b2;
	}

	@Override
	public void verifier() {
		expr.verifier();
		blocSi.verifier();
		if(blocSinon != null){
			blocSinon.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append(expr.toMIPS());
		if(blocSinon != null){
			sb.append(
			"bnez $v0, si\n"
			+ "j sinon\n"
			+ "si:");
			sb.append(blocSi.toMIPS());
			sb.append("j fin\n"
			+ "sinon:");
			sb.append(blocSinon.toMIPS());
			sb.append("fin:\n");
		}else{
			sb.append("bez $v0, fin\n");
			sb.append(blocSi.toMIPS());
			sb.append("fin:\n");
		}
		
		return sb.toString();
	}

	
	
}
