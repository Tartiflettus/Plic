package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.arbre.expression.VariableEntiere;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.Tds;

public class AffectationEntier extends Affectation {

	public AffectationEntier(Entree idf, Expression droite) {
		super(idf, droite);
	}

	@Override
	public void verifier() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(idf);
		if(droite.getType() != Expression.ENTIER){
			throw new AnalyseSemantiqueException(getNoLigne(), 0, "L'expression droite n'est pas entière");
		}		
	}

	@Override
	public String toMIPS() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(idf);
		return droite.toMIPS() + "sw $v0, " + s.getDeplacement() + "($s7)\n";
	}

}
