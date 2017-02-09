package plic.arbre.instruction;

public class Ecrire extends Instruction {
	private String chaine;
	
	private static int numLabelActu = 0;
	
	public Ecrire(int no, String chaine) {
		super(no);
		this.chaine = chaine;
	}

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		String res = "li $v0, 4\n"
				+ "li $a0, str"+ (numLabelActu) +"\n"
				+ "syscall\n"
				+ "b finsyscall" + (numLabelActu) +"\n"
				+ "str"+ (numLabelActu) +": .asciiz \""+ (numLabelActu) +"\"\n"
				+ "finsyscall "+ (numLabelActu) +":\n";
		numLabelActu++;
		return res;
	}
	
	

}
