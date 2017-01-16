package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
	
	public static final int CONSTANTE_ENTIERE = 1;
	public static final int CONSTANTE_BOOL = 2;
	public static final int BINAIRE_ARITHMETIQUE = 3;
	public static final int BINAIRE_LOGIQUE = 4;
	public static final int COMPARAISON = 5;
    
    protected Expression(int n) {
        super(n) ;
    }
    
    public abstract int getType();

}
