package plic.exceptions;

public class AnalyseSemantiqueException extends AnalyseException{
	
	public AnalyseSemantiqueException(int ligne, int colonne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + " colonne " + colonne + "\n\t" + m) ;
	}

}
