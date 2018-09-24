package Adrien;

public class Propri�t�GraphNiveauSup�rieur�0 {
	
	///////////////////////////////// SI Niveau>0 et type de fichier == graph 

	
private String ctab [] [];
	
	public Propri�t�GraphNiveauSup�rieur�0(String tableau_�_tester[] [])
	{
		this.ctab = tableau_�_tester;
		
	}
	
	public String verife2Tab() {
		String erreur1 = " Il y a au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)";
		String erreur2 = " Le graphe est orient� et valu�";
		String erreur3 = " Il y a au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)";
		String erreur = " Aucune erreur de niveuau 1 d�tect�e pour le graphe";
		
		
		int NBarc = Integer.parseInt(ctab[1][0]);
		int taille_du_tableau = ctab.length; //nb lignes
		
		for(int i = NBarc+2; i<taille_du_tableau; i++)
		{
			if (ctab[i][0] != null)
			{
				erreur1 = " Erreur : il y a un arc en trop qui est d�crit dans le fichier text";
				//au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)
			}
		}
				
		
		for(int i = 2; i<taille_du_tableau; i++)
		{			
			if (ctab[i][2] == "X")
			{
				erreur2 = " Erreur : l'arc de "+ ctab[i] [0] + " vers " + ctab[i] [1] + " n'a pas de valeur";
				//graphes orient�s et valu�s 
			}
			String avant [] = {ctab [i] [0],ctab[i] [1]};
		
			for(int j = 3; j<taille_du_tableau; j++)
			{
				String actuel [] = {ctab [j] [0],ctab[j] [1]};
			
				if(i!=j)
				{
					if(j>i) 
					{
						if(avant[0]==actuel[0])
						{
							if(avant[1]==actuel[1])
							{
								erreur3 = " Erreur : il y a deux fois l'arc du sommet " + ctab[i][0] + " vers le sommet "  
											+ ctab[i][1] + " qui est d�crit dans le fichier text";
								//au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)
							}
						}
					}
				}
			}
		}

		if (erreur1!=" Il y a au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)"
			||erreur2!=" Le graphe est orient� et valu�"
			||erreur3!=" Il y a au maximum 1 arc d�un sommet donn� vers 1 autre sommet donn� (pas de multigraphes)")
		{
			erreur = erreur1+" \n "+erreur2+" \n "+erreur3;
		}
		return erreur;
	}
}
