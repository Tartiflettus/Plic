package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.arbre.variable.VariableEntiere;
import plic.exceptions.AnalyseSemantiqueException;

public class AffectationEntier extends Affectation {

	public AffectationEntier(VariableEntiere idf, Expression droite) {
		super(idf, droite);
	}

	@Override
	public void verifier() {
		if(droite.getType() != Expression.ENTIER){
			throw new AnalyseSemantiqueException(getNoLigne(), 0, "L'expression droite n'est pas entière");
		}
		
		//TODO : vérifier l'idf
		
	}

	@Override
	public String toMIPS() {
		return null; //TODO
	}

}
