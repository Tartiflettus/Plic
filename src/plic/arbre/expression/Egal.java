package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

    
    
    @Override
    public String toMIPSEnd(){
    	return "sub $v0, $t8, $v0\n" + "addi $v0, $v0, 1";
    }
    
}
