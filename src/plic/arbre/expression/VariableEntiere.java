package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.Tds;

public class VariableEntiere extends Variable {

	public VariableEntiere(int no, Entree idf) {
		super(no, idf);
	}

	@Override
	public void verifier() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(idf);
		if(s == null){
			throw new AnalyseSemantiqueException(noLigne, 0, "Double déclaration : "+idf.getNom());
		}
	}

	@Override
	public String toMIPS() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(idf);
		assert(s != null);
		return "lw $v0, " + s.getDeplacement() + "($s7)\n";
	}

	@Override
	public int getType() {
		return Expression.ENTIER;
	}

}
