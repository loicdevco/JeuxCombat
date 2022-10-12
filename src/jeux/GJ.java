package jeux;

public class GJ extends Personnage {

	public GJ(String param_nom) {
		super(param_nom);
		// TODO Auto-generated constructor stub
		this.setAttaque(this.attaque - 5);
		this.setDefense(this.defense - 5);
		this.setVie(this.vie + 5);
		this.setType("GJ");

	}

}
