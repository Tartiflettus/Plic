package plic.tds;

public class Symbole {
	private int spec;
	private Type type;
	private static int deplMem=0;
	private int depl;

	public Symbole(int acces, Type t){
		spec=acces;
		type=t;
		depl = deplMem;
		deplMem-=4;
	}

	
	public int getSpec(){
		return spec;
	}
	
	public Type getType(){
		return type;
	}
	
	public int getDeplacement(){
		return depl;
	}
	
}
