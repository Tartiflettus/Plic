package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 dﾃｩc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public int getType() {
		return Expression.ENTIER;
	}

	@Override
	public void verifier() {  	
    	if(expression.getType() != Expression.ENTIER){
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"Moins unaire d'une expression non entière."));
    	}
    	expression.verifier();
	}
	
	@Override
	public String toMIPSEnd(){
		return "sub $v0, $zero, $v0\n";
	}

}
