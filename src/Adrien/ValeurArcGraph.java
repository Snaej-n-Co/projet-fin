package Adrien;

public class ValeurArcGraph {
	///////////////////////////////// SI Niveau>1 et type de fichier == graph 

	
	private String ctab [] [];
	
	public ValeurArcGraph(String tableau_�_tester[] [])
	{
		this.ctab = tableau_�_tester;
		
	}
	
	
	public String verife2Tab() {
		String erreur1 = " Tous les arcs sortant d�un m�me sommet ont une m�me valeur";
		String erreur2 = " Les valeurs des arcs sont positives ou nulles";
		String erreur = " Tous les arcs sortant d�un m�me sommet ont une m�me valeur et "
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
					erreur1 = " Erreur : les arcs sortant du sommet " + ctab[i][0] + " n'ont pas le m�me valeur";
					//tous les arcs sortant d�un sommet ont une m�me valeur
					}
					if (Integer.parseInt(ctab[i][2])<0)
					{
					erreur2=" Erreur : les arcs sortant du sommet " + ctab[i][0] + " ont une valeur n�gative";
					//les valeurs des arcs sont positives ou nulles
					}
				}
			}
		}
		if (erreur1!=" Tous les arcs sortant d�un m�me sommet ont une m�me valeur"
			||erreur2!=" Les valeurs des arcs sont positives ou nulles")
		{
			erreur = erreur1+"\n"+erreur2;
		}
		return erreur;
	}
	
	
}
