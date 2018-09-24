package Alex;

////////////	Detection de circuit
////////////	Niveau 1.1 (Après l'affichage du graphe)



public class Circuit
{
	public Circuit() {}
	

	public boolean DetectionDeCircuit(String[][] tab_graphe) //retourne true si il y a un circuit, false sinon
	{
		String[][] tab_detection = tab_graphe;
		int nbr_sommet = tab_detection.length;
		boolean change = false;
		int etape = 1;
		
		boolean[] circuit = new boolean[nbr_sommet]; // Tableau de boolean qui va dépendre de l'existance d'un sommet
		for (int i = 0;i < nbr_sommet;i++)
		{
			circuit[i] = false; // Initialisation
		}

		do
		{
			change = false;
			String viewetape = "Etape: ";
			System.out.println(viewetape + etape);

			for (int i = 0;i < nbr_sommet;i++)
			{
				boolean remove_sommet = true;
				for (int y = 0;y < nbr_sommet;y++)
				{
					if (tab_detection[y][i] !="X") // On parcour le tableau a la racherche d'un vide (ici X)
					{
						remove_sommet = false;
						y = nbr_sommet;
						
					}
					/*else if (tab_detection[i][y] !="X" *|| circuit[i] != false)
					{
						remove_sommet = false;
						y = nbr_sommet;
						
					}
					*/
				}
				if (remove_sommet && circuit[i] == false)//Le sommet i est une racine, on peut le retirer
				{
					circuit[i] = true;
					change = true;
				}
				else if (circuit[i] == false)// Impossible de retiret le sommet
				{
					System.out.println("Le sommet "+(i)+" n'est pas une racine, on ne peut donc pas le retirer ");
				}
			}

			for (int i = 0;i < nbr_sommet;i++) // On parcour l'ensemble des sommets
			{
				if (circuit[i] ==true) // Si l'on supprime le sommet i
				{
					for (int x = 0;x < nbr_sommet;x++) // On reparcour les sommets pour que chaque arrete lier au sommet supprimer i soit 'coupé'
					{
						tab_detection[i][x] = "X";
					}
				}
			}

			/**if (change) //Si on a réaliser une suppression on réaffiche le tableau avec la modification
			{
				return tab_detection;
			}
			else // Aucun sommet n'est une racine donc impossible de les supprimer
			{
				String echec = "Etape identique a la precedente, on s'arrete la.Soit nous sommes en presence d'un circuit, soit tous les sommets sont deja retires.";
				return echec;
			}*/
			etape++;
		} while (change != false);

		
		for (int i = 0;i < nbr_sommet;i++) // On parcour l'ensemble des sommets
		{
			if (!circuit[i])// Si on ne peut pas enlever ce sommet i alors presence d'un circuit
			{
				//String reponse = "Nous sommes en presence d'un circuit !";
				return true;
			}
		}


		//String erreur = "Il n'y a pas de circuit dans le graphe !";
		return false;
	}
	
		
}

