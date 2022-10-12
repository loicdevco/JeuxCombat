package jeux;

public class CRS extends Personnage {

	public CRS(String param_nom) {
		super(param_nom);
		// TODO Auto-generated constructor stub

		this.setVie(this.vie - 5);
		this.setAttaque(this.attaque + 5);
		this.setDefense(this.defense + 5);
		this.setType("CRS");
	}

}
