package plic.arbre;

/**
 * 3 dﾃｩc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    // numﾃｩro de ligne du dﾃｩbut de l'instruction
    protected int noLigne ;
    
    protected ArbreAbstrait(int no) {
        noLigne = no ;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }

    public abstract void verifier() ;

    public abstract String toMIPS() ;   //ﾃ� ﾃｩcrire pour plic0


}
