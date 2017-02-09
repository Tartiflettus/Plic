package plic.tds;

public class Symbole {
	private int spec;
	private Type type;
	private static int deplMem=0;

	public Symbole(int acces, Type t){
		spec=acces;
		type=t;
		deplMem-=4;
	}

}
