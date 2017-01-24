package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 dﾃｩc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    public void verifier(){
    	
    	if(gauche.getType() != droite.getType()){
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"Comparaison de deux types différents."));
    	}
    	droite.verifier();
    	gauche.verifier();
    }
    
    @Override
    public int getType(){
    	return Expression.BOOL;
    }

}




