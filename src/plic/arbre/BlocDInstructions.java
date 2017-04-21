package plic.arbre;

import java.util.LinkedList;
import java.util.List;

import plic.arbre.instruction.Instruction;

/**
 * 3 dﾃｩc. 2015
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
	
	//code d'appel d'une fonction sans arguments, sans variables
	public static String appelFonction(String labelRetour){
		return "la $t8, "+labelRetour+"\nsw $t8, 0($sp)\naddi $sp, $sp, -4\n" //@retour
				+ "addi $sp, $sp, -4\n" //val de retour
				+ "addi $sp, $sp, -4\n" //numéro de bloc
				+ "sw $s7, 0($sp)\naddi $sp, $sp, -4\n" //chaînage arrière
				;
	}
	
	//code de retour d'une fonction sans arguments, sans variables
	public static String retourFonction(){
		return "addi $sp, $sp, 4\nlw $s7, 0($sp)\n" //chaînage arrière
				+ "addi $sp, $sp, 4\n" //numéro de bloc
				+ "addi $sp, $sp, 4\n" //val de retour
				+ "addi $sp, $sp, 4\nlw $t8, 0($sp)\njr $t8" //@retour
				;
	}

}
