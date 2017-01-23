package plic.arbre.expression;

/**
 * 3 dÃ©c. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super(gauche.getNoLigne());
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }

    public String toMIPS(){
    	StringBuilder mips = new StringBuilder();
		mips.append("" + gauche.toMIPS()); //calcul expression gauche
		mips.append("sw $v0, ($sp)" //empiler expression gauche
				+ "add $sp, -4");
		mips.append("" + droite.toMIPS()); //calcul expression droite
		mips.append("lw $t8, ($sp)" //dépiler expression gauche
				+ "add $sp, $sp, 4");
		mips.append(""+toMIPSEnd());
		return mips.toString();
    }
    public abstract String toMIPSEnd();
}
