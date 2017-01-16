package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
	
	public static final int BOOL = 1;
	public static final int ENTIER = 2;
    
    protected Expression(int n) {
        super(n) ;
    }
    
    public abstract int getType();

}
