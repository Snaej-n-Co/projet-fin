package Adrien;

public class ValeurArcGraph {
	///////////////////////////////// SI Niveau>1 et type de fichier == graph 

	
	private String ctab [] [];
	
	public ValeurArcGraph(String tableau_à_tester[] [])
	{
		this.ctab = tableau_à_tester;
		
	}
	
	
	public String verife2Tab() {
		String erreur1 = " Tous les arcs sortant d’un même sommet ont une même valeur";
		String erreur2 = " Les valeurs des arcs sont positives ou nulles";
		String erreur = " Tous les arcs sortant d’un même sommet ont une même valeur et "
				+ "les valeurs des arcs sont positives ou nulles";
		int taille_du_tableau = ctab.length; //nb lignes

		

		for(int i =2; i<taille_du_tableau;i++)
		{
			for(int j =3; j<taille_du_tableau;j++)
			{
				if (Integer.parseInt(ctab[i][0])==Integer.parseInt(ctab[j][0]))
				{
					if (Integer.parseInt(ctab[i][2])!=Integer.parseInt(ctab[j][2]))
					{
					erreur1 = " Erreur : les arcs sortant du sommet " + ctab[i][0] + " n'ont pas le même valeur";
					//tous les arcs sortant d’un sommet ont une même valeur
					}
					if (Integer.parseInt(ctab[i][2])<0)
					{
					erreur2=" Erreur : les arcs sortant du sommet " + ctab[i][0] + " ont une valeur négative";
					//les valeurs des arcs sont positives ou nulles
					}
				}
			}
		}
		if (erreur1!=" Tous les arcs sortant d’un même sommet ont une même valeur"
			||erreur2!=" Les valeurs des arcs sont positives ou nulles")
		{
			erreur = erreur1+"\n"+erreur2;
		}
		return erreur;
	}
	
	
}
