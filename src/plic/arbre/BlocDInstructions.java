package plic.arbre;

import plic.arbre.instruction.Instruction;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends Instruction {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	public void verifier() {
		expr.verifier();
	}
	
	@Override
	public String toMIPS(){
		return expr.toMIPS();
	}

}
