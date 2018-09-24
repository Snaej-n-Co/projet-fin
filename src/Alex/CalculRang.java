package Alex;

//////		Calcule du Rang
////// 		Niveau 1.2 ( apres la detection de circuit)

public class CalculRang {
	
	public CalculRang ()
	{
		
	}
	
	public String Rang(String [][] tab_graphe)//retourne le rang des sommets sous forme d'un tableau de string
	{
		String[][] tab_detection = tab_graphe;
		boolean change = false;
		int etape = 0, p=0;
		int nbr_sommet = tab_detection.length;
		int nbr_jenesaispas= tab_detection[0].length;
		String tab_rang = new String();		
		
		boolean[] rang = new boolean[nbr_sommet]; // Tableau de boolean qui va dépendre de l'existance d'un sommet
		for (int i = 0;i < nbr_sommet;i++)
		{
			rang[i] = false; // Initialisation
		}
		
		do   // Tant que change = false
		{
			change = false;

			System.out.println("Etape:   "+etape);

			for (int i = 0;i < nbr_sommet;i++) // On parcour les sommets 
			{
				boolean remove_sommet = true;
				for (int y = p;y <tab_detection[i].length ;y++) // On parcour les sommets 
				{
					if (tab_detection[y][i] != "X" /*|| rang[i] != false*/) // Si la valeur du tableau à l'indice [i][y] n'est pas null (==X) ou si le tableau des rang à l'indice i est non null 
					{
						remove_sommet = false; // On ne fait rien
						y = tab_detection[i].length; // on sort de la boucle (y)						
					}
				}
				if (remove_sommet && rang[i] == false) // Si le bolean est true et si le tableau de rang est null pour l'indice i
				{
					System.out.println("Le sommet "+(i+1)+" est une racine, il est donc de rang "+(etape));
					tab_rang +=(i+1)+" "; // Le tableau de rang prend la valeur i à l'indice etape
					change = true; // On effectue un changement
					rang[i]=true;
				}

			}
			for (int i = 0;i < nbr_sommet;i++)
			{
				if (rang[i]==true)// Si la valeur du tableau de rang en i n'est pas null
				{
					for (int x = 0;x < nbr_jenesaispas;x++)
					{
						tab_detection[i][x] = "X";// on remplace toute les valeurs du sommet i par X
					}
				}
			}
			etape++; // Apres changement on avance d'1 etape
			if (change == true)// Si on effectue un changement
			{
				System.out.println("Il n'y a plus de sommets a traiter"); // on affiche que le sommet a bien était supprimer
			}
			tab_rang +="/";
			p++;
		} while (change != false);

		return tab_rang;/////// Affiche le tableau des rangs(ordre croissant) et l'etapemax
		
	}
	
	
	

}
