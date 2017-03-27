package plic.arbre.instruction;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;
import plic.exceptions.AnalyseSemantiqueException;

public class TantQue extends Instruction {
	private Expression expr;
	private BlocDInstructions bloc;
	
	private static int numTantQue = 0;

	public TantQue(int no, Expression e, BlocDInstructions b) {
		super(no);
		expr = e;
		bloc = b;
	}

	@Override
	public void verifier() {
		expr.verifier();
		bloc.verifier();
		
		if(expr.getType() != Expression.BOOL){
			throw new AnalyseSemantiqueException(noLigne, 0, "Tant que attend une expression booléenne");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		
		int numTantQueActu = numTantQue++;
		
		sb.append("tantque"+numTantQueActu+":\n");
		sb.append(expr.toMIPS());
		sb.append("beqz $v0, fintantque"+numTantQueActu+"\n");
		sb.append(bloc.toMIPS());
		sb.append("b tantque"+numTantQueActu+"\n");
		sb.append("fintantque"+numTantQueActu+":\n");
		
		return sb.toString();
	}
}
