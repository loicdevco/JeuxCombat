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

	public void Attaquer(Personnage crs) {

		int chance = nombreAleatoire(0, 10);

		if (chance >= 7 && chance <= 9) {
			Caillassage(crs);

		} else if (chance == 10) {
			MouvementDeFoule(crs);

		} else {
			super.Attaquer(crs);
			System.out.println(consoleColor.PURPLE_BACKGROUND + "Aucun coup special !!!" + consoleColor.RESET);
		}

		this.info();
		crs.info();

	}

	public void Caillassage(Personnage crs) {
		crs.setVie(crs.getVie() - 5);
		System.out.println("attaque Caillassage sur " + crs.nom);
	}

	public void MouvementDeFoule(Personnage crs) {
		crs.setVie(crs.getVie() - 15);
		System.out.println("attaque Mouvement de Foule sur " + crs.nom);
	}

}
