package plic.arbre.instruction;

import plic.tds.Tdd;

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
		int num = Tdd.getInstance().ajouterDonnee(".asciiz " + chaine);
		String res = "li $v0, 4\n"
				+ "la $a0, data"+num + "\n"
				+ "syscall\n";
		numLabelActu++;
		return res;
	}
	
	

}
