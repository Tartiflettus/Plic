package plic.arbre.instruction;

import java.util.LinkedList;

import com.sun.javafx.fxml.expression.Expression;

import plic.tds.Entree;

public class Pour extends Instruction{
	
	private Entree idf;
	private Expression expDeb;
	private Expression expMid;
	private String operateur;
	private LinkedList<Instruction> instructions;
	
	protected Pour(int no,  Entree idf, Expression exp1, Expression expBool, String operateur, LinkedList<Instruction> instr) {
		super(no);
		this.idf = idf;
		expDeb = exp1;
		expMid = expBool;
		this.operateur = operateur;
		instructions = instr;
		
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		
		return s.toString();
	}

}
