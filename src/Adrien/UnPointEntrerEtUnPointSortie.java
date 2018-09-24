package Adrien;

public class UnPointEntrerEtUnPointSortie {
	
	///////////////////////////////// SI Niveau>1 et type de fichier == graph 

	
	private String ctab [] [];
	private int rang[];                   ///////// rang calculer par alex
	private int rangmax;

	public UnPointEntrerEtUnPointSortie(String tableau_à_tester[] [], int rang[], int rangmax)
	{
		this.ctab = tableau_à_tester;
		this.rang = rang;
		this.rangmax = rangmax;
		

	}

	public String verife2Tab() {
		String erreur1 = " Le graphe contient qu’un seul point d’entré";
		String erreur2 = " Le graphe contient qu’un seul point de sortie";
		String erreur = " Le graphe ne contient qu’un seul point d’entré et un seul point de sortie "
				+ "\nTout sommet est accessible depuis le point d’entré "
				+ "\nLe point de sortie est accessible depuis tous les autres sommets";
		int fin=-1;
		int p = -1;
		
		
		for(int i =0; i<rang.length;i++)
		{
			if (rang[i] > fin)
	           {
	            fin = rang[i];
	            p=i;
	           }
			for(int j =1; j<rang.length;j++)
			{
				if(i!=j)
				{
					if(rang[i]==rang[j])
					{
						if(rang[i]==0)
						{
							erreur1=" Erreur : le graphe ne contient pas qu’un seul point d’entré";
							// plusieur sommet de rang 0
						}
					}
				}		
			}
		}
		for(int j =0; j<rang.length;j++)
		{
			if(p!=j)
			{
				if (rang[p] == rang[j])
		           {
		            erreur2=" Erreur : le graphe ne contient pas qu'un seul point de sortie " + fin;
		            // plusieur sommet de rang max
		           }
			}
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		for(int i =0; i<rang.length;i++)
		{
			if (rang[i] > fin)
	           {
	            fin = rang[i];
	            p=i;
	           }
			for(int j =1; j<rang.length;j++)
			{
				if(i!=j)
				{
					if(rang[i]==rang[j])
					{
						if(rang[i]==0)
						{
							erreur1=" Erreur : le graphe ne contient pas qu’un seul Sommet d’entré";
							//plusieur du rang 0
						}
						if(rang[i]==rangmax)
						{
							erreur2 = " Erreur : le graphe ne contient pas qu’un seul Sommet de sortie";
							
						}
					}
				}		
			}
		}
		
		
		/*
/////////////////// inverser le calcul de rang d'Alex en partant de la fin ( inverser le programme )////////////////////////////////////
		/// le sommet rang min devient le sommet rang max
		//Dans la lecture du tableau type graphe il faut inverser le sommet de départ avec celui d'arriver :
		// Si  String tab[] []= { {"6"},{"7"},{"1","2","12"},{"1","0","12"},{"4","3","7"} ...
		//Cela devient String tab[] []= { {"6"},{"7"},{"2","1","12"},{"0","1","12"},{"3","4","7"} ...
		// a inserrer ici ou dans une nouvelle class
		
		
		int invrangmax = 3; 
		int invrang[]={2,3,2,0,1,1}; 
		int invfin=-1;
		int invp = -1;
		boolean inver=false;
		for(int i =0; i<invrang.length;i++)
		{
			if (invrang[i] > invfin)
	           {
	            invfin = invrang[i];
	            invp=i;
	           }
			for(int j =1; j<invrang.length;j++)
			{
				if(i!=j)
				{
					if(invrang[i]==invrang[j])
					{
						if(invrang[i]==0)
						{
							erreur2 = " Erreur : le graphe ne contient pas qu’un seul Sommet de sorties";
							// au moins un sommet de rang < rang max   sans successeur
							// DONC le point de sortie est accessible depuis tous les autres sommets nn vérifier
						}
						if(invrang[i]==invrangmax)
						{
							erreur1 = " Erreur : le graphe ne contient pas qu’un seul Sommet d'entré";
							//plusieur du rang 0
						}
					}
				}		
			}
		}*/
		
		if (erreur1!=" Le graphe contient qu’un seul point d’entré"||erreur2!=" Le graphe contient qu’un seul point de sortie")
		{
			erreur = erreur1+"\n"+erreur2;
		}
		
		
		return erreur;
	}
}