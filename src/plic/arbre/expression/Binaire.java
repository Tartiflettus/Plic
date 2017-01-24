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
		mips.append("sw $v0, ($sp)\n" //empiler expression gauche
				+ "addi $sp, $sp, -4\n");
		mips.append("" + droite.toMIPS()); //calcul expression droite
		mips.append("addi $sp, $sp, 4\n" //dépiler expression gauche
				+ "lw $t8, ($sp)\n" );
		mips.append(""+toMIPSEnd());
		//copie de v0 dans v1 pour permettre les tests de plic0
		mips.append( "end :\n"
				+ "move $v1, $v0\n"
				+ "li $v0, 10\n"
				+ "syscall");
		return mips.toString();
    }

    public abstract String toMIPSEnd();

}
