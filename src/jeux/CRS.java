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

	public void Attaquer(Personnage gj) {

		int chance = nombreAleatoire(0, 10);

		super.Attaquer(gj);

		if (chance >= 7 && chance <= 9) {
			Fumigene(gj);

		} else if (chance == 10) {
			CanonEau(gj);

		}

		this.info();
		gj.info();

	}

	public void Fumigene(Personnage gj) {
		gj.setVie(gj.getVie() - 5);
		System.out.println("attaque Fumigene sur " + gj.nom);
	}

	public void CanonEau(Personnage gj) {
		gj.setVie(gj.getVie() - 10);
		System.out.println("attaque canon à eau sur " + gj.nom);
	}

}
