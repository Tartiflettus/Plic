package plic.arbre.classe;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import plic.arbre.ArbreAbstrait;
import plic.arbre.instruction.Instruction;
import plic.tds.EntreeClasse;

public class Classe extends ArbreAbstrait {
	private List<Instruction> declarations;
	private EntreeClasse e;

	public Classe(int no, EntreeClasse idf) {
		super(no);
		this.e = idf;
		declarations = new LinkedList<Instruction>();
	}
	
	public Classe(int no, EntreeClasse idf, String heritage) {
		super(no);
		this.e = idf;
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
		
		sb.append(e.getNom() + ":\n");
		for(ArbreAbstrait a : declarations){
			sb.append(a.toMIPS());
		}
		
		return sb.toString();
	}

}
