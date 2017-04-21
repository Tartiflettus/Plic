package plic.arbre.expression;

import plic.arbre.BlocDInstructions;
import plic.arbre.instruction.Instruction;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.EntreeConstructeur;
import plic.tds.Symbole;
import plic.tds.Tds;

public class Instanciation extends Expression {
	EntreeConstructeur e;

	public Instanciation(int no, EntreeConstructeur e) {
		super(no);
		this.e = e;
	}

	@Override
	public void verifier() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(e);
		if(s == null){
			throw new AnalyseSemantiqueException(noLigne, 0, e.getNom() + " n'a pas été déclarée\n");
		}
	}

	@Override
	public String toMIPS() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(e);
		assert(s != null);
		
		return BlocDInstructions.appelFonction(e.getNom()+"_cons");
		
	}

	@Override
	public int getType() {
		return Expression.CLASSE;
	}

}
