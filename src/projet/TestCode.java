package projet;

public class TestCode {
	
		public static void main(String[] args)
		
		{
			int numéro_passer = 0;
			boolean erreur = false;
			int tableau_à_tester[] = {12,33,45,89,65,32,27,55,37,72,66,96,84,20,12};
			int copie_tableau_à_tester[] = tableau_à_tester;
			int taille_du_tableau = tableau_à_tester.length;
			
			for(int i = 0; i<taille_du_tableau; i++)
			{			
				for(int j = 0; j<taille_du_tableau; j++)
				{
					if(i!=j)
					{
						if(j>numéro_passer) 
						{
							//System.out.println((i+1) + " " + tableau_à_tester[i] + " et " + (j+1) + " " + copie_tableau_à_tester[j]);
							if(tableau_à_tester[i]==copie_tableau_à_tester[j])
							{
								System.out.println("erreur : il y a 2 fois " + tableau_à_tester[i] + " à la ligne " + (i+1) + " et " + (j+1) +" dans le fichier text");
								erreur=true;
							}
						}	
					}	
				}
				numéro_passer++;
			}
			if (erreur == false)
			{
				System.out.println("pas d'erreur : il n'y a pas 2 fois un des arc décrit dans le fichier text");
			}
		}
	
}
