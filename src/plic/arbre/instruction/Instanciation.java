package plic.arbre.instruction;

import plic.arbre.BlocDInstructions;
import plic.exceptions.AnalyseSemantiqueException;
import plic.tds.EntreeConstructeur;
import plic.tds.Symbole;
import plic.tds.Tds;

public class Instanciation extends Instruction {
	EntreeConstructeur e;

	public Instanciation(int no, EntreeConstructeur e) {
		super(no);
		this.e = e;
	}

	@Override
	public void verifier() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(e);
		if(s == null){
			throw new AnalyseSemantiqueException(noLigne, 0, e.getNom() + " n'a pas été déclarée\n");
		}
	}

	@Override
	public String toMIPS() {
		Tds tds = Tds.getInstance();
		Symbole s = tds.identifier(e);
		assert(s != null);
		
		return BlocDInstructions.appelFonction(e.getNom()+"_cons");
		
	}

}
