package plic.arbre.expression;

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
		String general = "Erreur ligne : ";
    	String att = " : non logique d'une expression non booléenne";
    	
    	if(expression.getType() != Expression.BOOL){
    		System.err.println(general + expression.getNoLigne() +att);
    	}
	}
	
	@Override
	public String toMIPSEnd(){
		return "not $v0, $v0\n";
	}

}
