package plic.arbre.instruction;

import java.util.LinkedList;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Constante;
import plic.arbre.expression.ConstanteEntiere;
import plic.arbre.expression.Expression;
import plic.arbre.expression.Moins;
import plic.arbre.expression.Plus;
import plic.arbre.expression.VariableEntiere;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.Entree;

public class Pour extends Instruction{
	
	private Affectation affect;
	private Entree idf2;
	private Expression expBool;
	private String operateur;
	private BlocDInstructions instructions;
	private int noLigne;
	private int pourNumActu;
	
	public Pour(int no,  Affectation aff, Expression expBool, Entree idf2, String operateur, BlocDInstructions instr) {
		super(no);
		affect = aff;
		this.idf2 = idf2;
		this.expBool = expBool;
		this.operateur = operateur;
		instructions = instr;
		noLigne = no;	
	}

	@Override
	public void verifier() {
		if(!affect.idf.getNom().equals(idf2.getNom())){
			throw new AnalyseSemantiqueException(getNoLigne(), 0, "Mauvaise variable changée donc boucle infinie!");
		}
		if(expBool.getType() != Expression.BOOL){
			throw new AnalyseSemantiqueException(getNoLigne(), 0, "L'expression du milieu n'est pas booléenne");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		s.append(affect.toMIPS());
		if(operateur.equals("++"))
			instructions.ajouter(new AffectationEntier(affect.idf, new Plus(new VariableEntiere(noLigne, affect.idf), new ConstanteEntiere(1+"", noLigne))));
		else if(operateur .equals("--"))
			instructions.ajouter(new AffectationEntier(affect.idf, new Moins(new VariableEntiere(noLigne, affect.idf), new ConstanteEntiere(1+"", noLigne))));
		TantQue tq = new TantQue(noLigne, expBool, instructions);
		s.append(tq.toMIPS());
		return s.toString();
	}

}
