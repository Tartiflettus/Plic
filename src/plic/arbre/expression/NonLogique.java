package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 dﾃｩc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public int getType() {
		return Expression.BOOL;
	}

	@Override
	public void verifier() {
    	if(expression.getType() != Expression.BOOL){
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"Non logique d'une expression non booléenne."));
    	}
    	expression.verifier();
	}
	
	@Override
	public String toMIPSEnd(){
		return "not $v0, $v0\n";
	}

}
