package Adrien;

public class NombreEtNum�roSommet {
	
	///////////////////////////////// SI Niveau>2 (niveau3) et type de fichier == contrainte 
	
	private String ctabc [] [];
	
	public NombreEtNum�roSommet(String tableau_�_tester[] [])
	{
		this.ctabc = tableau_�_tester;
	}
	
	public String[][] getCtabc() {
		return ctabc;
	}

	public void setCtabc(String[][] ctabc) {
		this.ctabc = ctabc;
	}

	public String verife2Tab() {
		int taille_du_tableauc = ctabc.length; //nb lignes
		int tabv�rif[]= new int [taille_du_tableauc];
		int NBsommet = Integer.parseInt(ctabc[0][0]);
		String erreur=" Les t�ches sont repr�sent�es par des nombres entiers, � partir de �1� et sans rupture de s�quence";
		
		for(int i = 1; i<NBsommet; i++)
		{
			tabv�rif [Integer.parseInt(ctabc[i][0])]= Integer.parseInt(ctabc[i][0]);
		}
		
		for(int i = 1; i<NBsommet; i++) ////////////////////v�rifie le nb et le num des sommets
		{
			if(tabv�rif[i]!=i)
			{
				erreur = " Erreur : au moins un des sommets n'est pas correctement d�crit";
				//Les t�ches sont repr�sent�es par des nombres entiers, � partir de �1�
				//et sans rupture de s�quence (par exemple de �1� � �10� pour un projet de 10 t�ches). 
			}
		}
		return erreur;
		
	}
	
	

}
