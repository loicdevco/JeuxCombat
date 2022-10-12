package jeux;

import java.util.Random;

public class Personnage {

	protected String nom;
	protected int vie;
	protected int attaque;
	protected int defense;
	protected boolean existe;

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
		if (vie <= 0) {
			vie = 0;
			this.setExiste(false);
		}
		this.vie = vie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		if (existe == false) {
			System.out.println(this.nom + " est mort!");
		}
		this.existe = existe;
	}

	public void info() {
		System.out.println(this.nom + " a " + this.vie + " points de vie, " + this.attaque
				+ " points d'attaque et enfin " + this.defense + " points de defense.");
	}

	public void Attaquer(Personnage defenseur) {
		if (this.existe && defenseur.existe && this != defenseur) {
			System.out.println(this.nom + " attaque " + defenseur.nom);
			if (this.attaque > defenseur.defense) {
				defenseur.setVie(defenseur.vie - 10);
			} else if (this.attaque == defenseur.defense) {
				defenseur.setVie(defenseur.vie - 5);
			} else {
				this.setVie(this.vie - 5);
			}
			this.info();
			defenseur.info();
		}

	}

}
