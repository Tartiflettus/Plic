package plic.arbre.expression;

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
    			System.out.println("Les deux expressions sont bien binaires");
    	}else if(gauche.getType() != Expression.BOOL){
    		System.out.println("L'expression de gauche n'est pas binaire");
    	}else{
    		System.out.println("L'expression de droite n'est pas binaire");
    	}
    }
}
