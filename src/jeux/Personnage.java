package jeux;

import java.util.Random;

public class Personnage {

	protected String nom;
	protected int vie;
	protected int attaque;
	protected int defense;
	protected boolean existe;
	protected String type;

	public Personnage(String param_nom) {
		if (param_nom == null || param_nom == "") {
			existe = false;
			System.out.println("Erreur Entrer un nom de personnage valide !");
			System.out.println(existe);

		} else {
			nom = param_nom;
			existe = true;
			System.out.println("Nouveau personnage " + param_nom + " créé !");
			System.out.println(existe);
		}

		this.vie = nombreAleatoire(20, 100);
		this.attaque = nombreAleatoire(20, 100);
		this.defense = nombreAleatoire(20, 100);
		this.type = "";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int nombreAleatoire(int min, int max) {

		Random random = new Random();

		return random.nextInt(max - min) + min;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		if (vie <= 100) {
			if (vie <= 0) {
				vie = 0;

				this.setExiste(false);
				System.out.println(consoleColor.RED_BACKGROUND + this.nom + " is Dead " + consoleColor.RESET);
			}
			this.vie = vie;
		} else {
			System.out.println("error");
		}
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		if (attaque <= 100 || attaque >= 20) {
			this.attaque = attaque;
		} else {
			System.out.println("error");
		}

	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		if (defense <= 100 || defense >= 20) {
			this.defense = defense;
		} else {
			System.out.println("error");
		}

	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public void info() {
		System.out.println(this.type + "\n" + this.nom + "\n" + "points de vie : " + this.vie + " \n" + "Attaque : "
				+ this.attaque + "\ndefense : " + this.defense);
	}

	public void Attaquer(Personnage defenseur) {
		if (this.existe && defenseur.existe && this != defenseur) {
			System.out.println(
					this.type + " -> " + this.nom + " attaque " + defenseur.nom + " qui est un " + defenseur.type);
			if (this.attaque > defenseur.defense) {
				defenseur.setVie(defenseur.vie - 10);
			} else if (this.attaque == defenseur.defense) {
				defenseur.setVie(defenseur.vie - 5);
			} else {
				this.setVie(this.vie - 5);
			}
		}

	}

}
