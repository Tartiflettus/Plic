package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Unaire extends Expression {
    
    protected Expression expression ;

    protected Unaire(Expression expr) {
        super(expr.getNoLigne());
        expression = expr ;
    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + operateur() + expression + ")" ;
    }
    
    
    @Override
    public String toMIPS(){
    	return expression.toMIPS() + "sw $v0, 0($sp)\n" + "addi $sp, $sp, -4\n" + toMIPSEnd();
    }
    
    public abstract String toMIPSEnd();

}
