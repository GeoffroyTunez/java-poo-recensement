package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.CodeException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws CodeException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		if (!choix.matches("\\d+")) {
			throw new CodeException("Vous n'avez pas rentré un nombre ! ");
		}
		System.out.println("Choisissez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		if (!saisieMin.matches("\\d+")) {
			throw new CodeException("Vous n'avez pas rentré un nombre ! ");
		}

		System.out.println("Choisissez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();

		if (!saisieMax.matches("\\d+")) {
			throw new CodeException("Vous n'avez pas rentré un nombre ! ");
		}



		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;


		if(choix != null ){
			throw new CodeException("La population minimum ne peut pas être supérieure à la population maximum.");
		}

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}else{
				throw new CodeException("Le code de département ne correspond pas a un département enregistrer!");
			}
		}
	}

}
