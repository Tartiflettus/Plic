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
    	String att = " : comparaison de 2 types différents";
    	
    	if(gauche.getType() != droite.getType()){
    		System.err.println(general + gauche.getNoLigne() +att);
    	}
    }
    
    @Override
    public int getType(){
    	return Expression.BOOL;
    }

}
