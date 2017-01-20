package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier(){
    	if(gauche.getType() == Expression.ENTIER && droite.getType() == Expression.ENTIER){
			System.out.println("Les deux expressions sont bien entieres");
    	}else if(gauche.getType() != Expression.ENTIER){
    		System.out.println("L'expression de gauche n'est pas entiere");
    	}else{
    		System.out.println("L'expression de droite n'est pas entiere");
    	}
    }
    
}
