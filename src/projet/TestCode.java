package projet;

public class TestCode {
	
		public static void main(String[] args)
		
		{
			int num�ro_passer = 0;
			boolean erreur = false;
			int tableau_�_tester[] = {12,33,45,89,65,32,27,55,37,72,66,96,84,20,12};
			int copie_tableau_�_tester[] = tableau_�_tester;
			int taille_du_tableau = tableau_�_tester.length;
			
			for(int i = 0; i<taille_du_tableau; i++)
			{			
				for(int j = 0; j<taille_du_tableau; j++)
				{
					if(i!=j)
					{
						if(j>num�ro_passer) 
						{
							//System.out.println((i+1) + " " + tableau_�_tester[i] + " et " + (j+1) + " " + copie_tableau_�_tester[j]);
							if(tableau_�_tester[i]==copie_tableau_�_tester[j])
							{
								System.out.println("erreur : il y a 2 fois " + tableau_�_tester[i] + " � la ligne " + (i+1) + " et " + (j+1) +" dans le fichier text");
								erreur=true;
							}
						}	
					}	
				}
				num�ro_passer++;
			}
			if (erreur == false)
			{
				System.out.println("pas d'erreur : il n'y a pas 2 fois un des arc d�crit dans le fichier text");
			}
		}
	
}
