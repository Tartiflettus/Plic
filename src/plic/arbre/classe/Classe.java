package plic.arbre.classe;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import plic.arbre.ArbreAbstrait;
import plic.arbre.instruction.Instruction;

public class Classe extends ArbreAbstrait {
	private List<Instruction> declarations;

	public Classe(int no) {
		super(no);
		declarations = new LinkedList<Instruction>();
	}
	
	
	
	public void ajouterTout(Collection<? extends Instruction> c){
		declarations.addAll(c);
	}
	

	@Override
	public void verifier() {
		for(ArbreAbstrait a : declarations){
			a.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		
		for(ArbreAbstrait a : declarations){
			sb.append(a.toMIPS());
		}
		
		return sb.toString();
	}

}
