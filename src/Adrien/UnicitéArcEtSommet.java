package Adrien;

public class UnicitéArcEtSommet {
	
	///////////////////////////////// SI Niveau>0 et type de fichier == contrainte 

private String ctabc [] [];
	
	public UnicitéArcEtSommet(String tableau_à_tester[] [])
	{
		this.ctabc = tableau_à_tester;
		
	}
	
	public String verife2Tab() {
		String erreur1 = " Chaque sommet est décrit au maximum une fois";
		String erreur2 = " Il y a au maximum 1 arc d’un sommet donné vers 1 autre sommet donné (pas de multigraphes)";
		String erreur = " Il y a au maximum 1 arc d’un sommet donné vers 1 autre sommet donné (pas de multigraphes) et "
				+ "chaque sommet est décrit au maximum une fois";
		int departa;
		int departb;
		int taille_du_tableauc = ctabc.length; //nb lignes
		int NBsommet = Integer.parseInt(ctabc[0][0]);
		
		for(int i = NBsommet+1; i<taille_du_tableauc; i++)
		{			
			departa = Integer.parseInt(ctabc[i][0]);
			
			for(int ii = NBsommet+2; ii<taille_du_tableauc; ii++)
			{
				if(i<ii)
				{
					departb = Integer.parseInt(ctabc[ii][0]);
					if(departa==departb)
					{
						erreur1 = " Erreur : il y a deux fois le sommet " + departa + " qui est décrit dans le fichier text "
								+ "type contrainte";
						//le sommet est décrit sur deux lignes différentes (pas demander dans le sujet)
					}
				}
			}
			int tailletabccol=ctabc[i].length;
			for (int j = 1; j<tailletabccol;j++)
			{
				int avant = Integer.parseInt(ctabc[i][j]);
				
				for (int k = 2; k<tailletabccol;k++)
				{
					if(k>j)
					{
						
						int actuel = Integer.parseInt(ctabc[i][k]);
						if (avant==actuel)
						{
							erreur2 = " Erreur : il y a deux fois l'arc du sommet " + ctabc[i][0] + " vers le sommet "
									+ ctabc[i][j] + " qui est décrit dans le fichier text type contrainte";
							//au maximum 1 arc d’un sommet donné vers 1 autre sommet donné (pas de multigraphes)
						}
					}
				}
			}
		}
		if (erreur1!=" Chaque sommet est décrit au maximum une fois"||erreur2!=" Il y a au maximum 1 arc d’un sommet donné vers 1 autre sommet donné (pas de multigraphes)")
		{
			erreur = erreur1+"\n"+erreur2;
		}
		return erreur;
	}
	
	
}
