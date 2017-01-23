package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    @Override
    public void verifier(){
    	if(gauche.getType() == Expression.ENTIER && droite.getType() == Expression.ENTIER){
			//System.out.println("Les deux expressions sont bien entieres");
    	}else if(gauche.getType() != Expression.ENTIER){
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"L'expression de gauche n'est pas entiere"));
    	}else{
    		throw(new AnalyseSemantiqueException(this.getNoLigne(),1,"L'expression de droite n'est pas entiere"));
    	}
    }
    
    @Override
    public int getType(){
    	return Expression.ENTIER;
    }
    
}
