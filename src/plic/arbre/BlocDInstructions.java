package plic.arbre;

import java.util.LinkedList;
import java.util.List;

import plic.arbre.instruction.Instruction;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends Instruction {
    private List<Instruction> instructions;
    
    public BlocDInstructions(int n) {
        super(n) ;
        instructions = new LinkedList<Instruction>();
    }
    
    public void ajouter(Instruction i) {
        instructions.add(i);
    }
    

	@Override
	public void verifier() {
		for(Instruction elem : instructions){
			elem.verifier();
		}
	}
	
	@Override
	public String toMIPS(){
		StringBuilder sb = new StringBuilder();
		
		for(Instruction elem : instructions){
			sb.append(elem.toMIPS());
		}
		
		return sb.toString();
	}

}
