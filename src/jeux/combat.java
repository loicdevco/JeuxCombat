package jeux;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class combat {
	public static void main(String[] args) {

		final int nbreJoueur = 4;
		int i = 0;
		String nextType = "CRS";

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
					if (Players.size() % 2 == 0) {
						Personnage perso = new CRS(nomJoueur);
						perso.info();
						Players.add(perso);
					} else {
						Personnage perso = new GJ(nomJoueur);
						perso.info();
						Players.add(perso);
					}

				}
			} else {
				if (Players.size() % 2 == 0) {
					Personnage perso = new CRS(nomJoueur);
					perso.info();
					Players.add(perso);
				} else {
					Personnage perso = new GJ(nomJoueur);
					perso.info();
					Players.add(perso);
				}
			}

		} while (Players.size() < nbreJoueur);

		run(Players);

	}

	public static void run(ArrayList<Personnage> PlayersMatch) {

		Personnage winner;
		int round = 1;

		if (PlayersMatch.size() % 2 == 0) {
			while (PlayersMatch.size() > 1) {

				int a = 0;
				int d = 0;

				do {
					a = new Random().nextInt(PlayersMatch.size());
					d = new Random().nextInt(PlayersMatch.size());
				} while (a == d);

				Personnage attaquant = PlayersMatch.get(a);
				Personnage defenseur = PlayersMatch.get(d);

				if (attaquant.type != defenseur.type) {
					System.out.println("debut du round " + round);
					while (attaquant.existe == true && defenseur.existe == true) {

						attaquant.Attaquer(defenseur);

						if (attaquant.existe == false) {
							PlayersMatch.remove(a);
							System.out.println(consoleColor.YELLOW_BACKGROUND + defenseur.nom + " a gagné le round "
									+ round + consoleColor.RESET);
							round++;
						} else if (defenseur.existe == false) {
							PlayersMatch.remove(d);
							System.out.println(consoleColor.BLUE_BACKGROUND + attaquant.nom + " a gagné le round "
									+ round + consoleColor.RESET);
							round++;
						}
					}

				}

			}

			winner = PlayersMatch.get(0);
			win(winner);
			// System.out.println(PlayersMatch.get(0).nom + " a gagné!!");
		}

	}

	public static void win(Personnage winner) {
		System.out.println(winner.nom);
		winner.info();
	}

}