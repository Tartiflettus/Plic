package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public int getType() {
		return Expression.ENTIER;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public String toMIPS(){
    	return "li $v0, "+cste + "\n";
    }

}
