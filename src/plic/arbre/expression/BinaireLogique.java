package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier(){
    	if(gauche.getType() == Expression.BOOL && droite.getType() == Expression.BOOL){
    			//System.out.println("Les deux expressions sont bien binaires");
    	}else if(gauche.getType() != Expression.BOOL){
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"L'expression de gauche n'est pas binaire."));
    	}else{
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"L'expression de droite n'est pas binaire."));
    	}
    	droite.verifier();
    	gauche.verifier();
    }
    
    @Override
    public int getType(){
    	return Expression.BOOL;
    }
}
