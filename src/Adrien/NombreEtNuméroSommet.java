package Adrien;

public class NombreEtNuméroSommet {
	
	///////////////////////////////// SI Niveau>2 (niveau3) et type de fichier == contrainte 
	
	private String ctabc [] [];
	
	public NombreEtNuméroSommet(String tableau_à_tester[] [])
	{
		this.ctabc = tableau_à_tester;
	}
	
	public String[][] getCtabc() {
		return ctabc;
	}

	public void setCtabc(String[][] ctabc) {
		this.ctabc = ctabc;
	}

	public String verife2Tab() {
		int taille_du_tableauc = ctabc.length; //nb lignes
		int tabvérif[]= new int [taille_du_tableauc];
		int NBsommet = Integer.parseInt(ctabc[0][0]);
		String erreur=" Les tâches sont représentées par des nombres entiers, à partir de ‘1’ et sans rupture de séquence";
		
		for(int i = 1; i<NBsommet; i++)
		{
			tabvérif [Integer.parseInt(ctabc[i][0])]= Integer.parseInt(ctabc[i][0]);
		}
		
		for(int i = 1; i<NBsommet; i++) ////////////////////vérifie le nb et le num des sommets
		{
			if(tabvérif[i]!=i)
			{
				erreur = " Erreur : au moins un des sommets n'est pas correctement décrit";
				//Les tâches sont représentées par des nombres entiers, à partir de ‘1’
				//et sans rupture de séquence (par exemple de ‘1’ à ‘10’ pour un projet de 10 tâches). 
			}
		}
		return erreur;
		
	}
	
	

}
