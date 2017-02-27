package plic.tds;

import java.util.ArrayList;

public class Tdd {
	private static Tdd instance = new Tdd();
	
	private ArrayList<Object> data;

	private Tdd() {
		data = new ArrayList<Object>();
	}
	
	public static Tdd getInstance(){
		return instance;
	}
	
	
	public int ajouterDonnee(Object o){
		data.add(o);
		return data.size()-1;
	}
	
	
	public String toMIPS(){
		StringBuilder sb = new StringBuilder();
		sb.append(".data\n");
		for(int i=0; i < data.size(); i++){
			sb.append("data"+i+": " + data.get(i).toString() + "\n");
		}
		sb.append(".text\n");
		sb.append("move $s7, $sp\n");
		sb.append("addi $sp, $sp, "+Tds.getInstance().getDeplacementMemoire()+"\n");
		return sb.toString();
	}

}
