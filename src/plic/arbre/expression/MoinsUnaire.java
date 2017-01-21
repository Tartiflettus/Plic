package plic.arbre.expression;

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
		String general = "Erreur ligne : ";
    	String att = " : moins unaire d'une expression non entière";
    	
    	if(expression.getType() != Expression.ENTIER){
    		System.err.println(general + expression.getNoLigne() +att);
    	}
	}

}
