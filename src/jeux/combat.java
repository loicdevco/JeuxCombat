package jeux;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class combat {
	public static void main(String[] args) {

		final int nbreJoueur = 4;
		int i = 0;
		ArrayList<Personnage> Players = new ArrayList<Personnage>();

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Saisir le nom du joueur : ");

			String nomJoueur = sc.next();

			if (Players.size() > 0) {
				boolean isExist = false;
				for (i = 0; i < Players.size(); i++) {
					if (Players.get(i).nom.equalsIgnoreCase(nomJoueur)) {
						System.out.println("Error");
						isExist = true;
					}
				}
				if (isExist == false) {
					Personnage perso = new Personnage(nomJoueur);
					perso.info();
					Players.add(perso);
				}
			} else {
				Personnage perso = new Personnage(nomJoueur);
				perso.info();
				Players.add(perso);
			}
			System.out.println(Players);

		} while (Players.size() < nbreJoueur);
		run(Players);
	}

	public static void run(ArrayList<Personnage> PlayersMatch) {

		while (PlayersMatch.size() > 1) {

			int a = 0;
			int d = 0;

			do {
				a = new Random().nextInt(PlayersMatch.size());
				d = new Random().nextInt(PlayersMatch.size());
			} while (a == d);

			Personnage attaquant = PlayersMatch.get(a);
			Personnage defenseur = PlayersMatch.get(d);

			attaquant.Attaquer(defenseur);
			defenseur.Attaquer(attaquant);

			if (attaquant.existe == false) {
				PlayersMatch.remove(a);
			} else if (defenseur.existe == false) {
				PlayersMatch.remove(d);
			}

		}
		System.out.println(PlayersMatch.get(0).nom + " a gagné !!!!");

	}

	// PlayersMatch.get(i).Attaquer(PlayersMatch.get(i + 1));
	// PlayersMatch.get(i + 1).Attaquer(PlayersMatch.get(i));

}