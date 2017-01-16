package plic.arbre.expression;

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
    	String general = "Erreur ligne : ";
    	String att = " : expression entière attendue";
    	
    	if(gauche.getType() != Expression.ENTIER){
    		System.err.println(general + gauche.getNoLigne() +att);
    	}
    	if(droite.getType() != Expression.ENTIER){
    		System.err.println(general + droite.getNoLigne() +att);
    	}
    }

}
