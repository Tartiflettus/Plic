package plic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;
import plic.tds.Tdd;

/**
 * 24 mars 2015
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Plic {

	public Plic(String fichier, String classePrincipale) {
		try {
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
			ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
			arbre.verifier();
			String arbreMips = arbre.toMIPS();
			String dataMips = Tdd.getInstance().toMIPS();
			creationFichierMIPS(dataMips + arbreMips + "end :\n" + "move $v1, $v0\n" + "li $v0, 10\n" + "syscall", fichier);
			System.out.println("Compilation OK");

		} catch (FileNotFoundException ex) {
			System.err.println("Fichier " + fichier + " inexistant");
		} catch (AnalyseException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			Logger.getLogger(Plic.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void creationFichierMIPS(String s, String fichier) {
		try {
			if (fichier.indexOf('.') > -1) {
				String [] parts = fichier.split("\\.");
				fichier = parts[0];
			}
			FileWriter save = new FileWriter(fichier + ".mips");
			save.write(s.toString());
			save.write("\r\n");
			save.close();
		} catch (IOException exception) {
			System.out.println("Erreur lors de l'馗riture : " + exception.getMessage());
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Nombre incorrect d'arguments");
			System.err.println("\tjava -jar plic.jar <fichierSource.plic> <pointdentrée>");
			System.exit(1);
		}

		new Plic(args[0], args[1]);
	}
}
