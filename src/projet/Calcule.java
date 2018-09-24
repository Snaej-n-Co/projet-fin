package projet;

import Adrien.*;
import Alex.CalculRang;
import Alex.Circuit;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Calcule {

	public Calcule(Enregistrement data, int niv) throws FileNotFoundException {
		
		
		Enregistrement dataUtiliser = data;   //contraite ou graph
		int niveau =niv;
		 switch (niveau) {
		case 1:
			niveau1(dataUtiliser);
			break;
		case 2:
			niveau2(dataUtiliser);
			break;
		case 3:
			niveau3(dataUtiliser);
			break;
		case 4:
			niveau4(dataUtiliser);
			break;

		default:
			break;
		}
		
		
		
		
	
	}
	private void niveau1(Enregistrement data) throws FileNotFoundException {
		Enregistrement dataUtiliser = data;
			
		System.out.println("data : //////////////////   "+data);
		
		switch (dataUtiliser.getType()) {
		case "contraite":
			String tableauContraintePourAlex[][] = dataUtiliser.getDataContraite();
			ArrayList<String> tmp = dataUtiliser.Lecture_Spesifique();
			
			System.out.println(tmp);
			int Nbsommets= Integer.parseInt(tmp.get(0));
			String tabfin[][]= new String[((Nbsommets*2)+1)][];
			tabfin[0] = new String[1];
			for(int i=0 ; i<Nbsommets;i++ ) {
				tabfin[i+1] = new String[2];
			}
			for(int i=Nbsommets ; i<(2*Nbsommets);i++ ) {
				int l;
				l = tmp.size() - tmp.get(i).replace(" ", "").length();
				tabfin[i+1] = new String[l];
			}
			
			for(int i=1;i<tmp.size();i++) {
				
				String tabTmp[]=tmp.get(i).split("\n");
				for(int j=2;j<3;j++) {
					tabfin[i]=tabTmp[j-2].split(" ");

				}
			}
			tabfin[0][0]= tmp.get(0);

			
			System.out.println("///////Tableau de contrainte dont a besoin Adrien : ////////////");
			for(int i = 0 ; i < tabfin.length; i++)
			{
				for(int j = 0; j<tabfin[i].length;j++)
				{
					System.out.print(tabfin[i][j]+"		");
				}
				System.out.println("\n");
			}
			String [] [] tableauDeContrainte = tabfin;
			UnicitéArcEtSommet U_A_et_S = new UnicitéArcEtSommet(tableauDeContrainte);
			String uas= U_A_et_S.verife2Tab();
			if(uas.contains("Erreur")) {
				dataUtiliser.Ecriture_Erreu(uas);
			}
			else {
				dataUtiliser.Ecriture_Preuve(uas);
			}
			
			Circuit det_circuit = new Circuit();
			Boolean test_circuit = det_circuit.DetectionDeCircuit(tableauContraintePourAlex);//////////////////:détection de circuit a ajouter ////////////////////////
					
			if(test_circuit == false)
			{
			CalculRang det_rang = new CalculRang();
			String nouv_rang = det_rang.Rang(tableauContraintePourAlex); ///////////////////////:calcul de rang ////////////////////////
			dataUtiliser.Ecriture_Preuve(nouv_rang);
			}
			

			break;
		case "graph": 
			String tableauGraphePourAlex[][] = dataUtiliser.getDataGraph();
			ArrayList<String> tmpgraph = dataUtiliser.Lecture_Spesifique();
			System.out.println(tmpgraph);
			int Nbsommetsgraph= Integer.parseInt(tmpgraph.get(0));
			String tabfingraph[][]= new String[Integer.parseInt(tmpgraph.get(1))+2][];
			tabfingraph[0] = new String[1];
			tabfingraph[1] = new String[1];
			
			for(int i=2;i<tmpgraph.size();i++) {
				tabfingraph[i] = new String[3];
				String tabTmp[]=tmpgraph.get(i).split("\n");
				for(int j=2;j<3;j++) {
					tabfingraph[i]=tabTmp[j-2].split(" ");

				}
			}
			tabfingraph[0][0]= tmpgraph.get(0);
			tabfingraph[1][0]= tmpgraph.get(1);

			
			System.out.println("///////Tableau de graph dont a besoin Adrien : ////////////");
			for(int i = 0 ; i < tabfingraph.length; i++)
			{
				for(int j = 0; j<tabfingraph[i].length;j++)
				{
					System.out.print(tabfingraph[i][j]+"		");
				}
				System.out.println("\n");
			}
			String tableauDeGraphe[][]=tabfingraph;
			PropriétéGraphNiveauSupérieurà0 P = new PropriétéGraphNiveauSupérieurà0(tableauDeGraphe);
			String p= P.verife2Tab();
			if (p.contains("Erreur")) {
				dataUtiliser.Ecriture_Erreu(p);
			}
			else {
				dataUtiliser.Ecriture_Preuve(p);
			}
		
			
			Circuit det_circuit_graphe = new Circuit();
			Boolean test_circuit_graphe = det_circuit_graphe.DetectionDeCircuit(tableauGraphePourAlex);//////////////////:détection de circuit a ajouter ////////////////////////		
			
			if(test_circuit_graphe ==  false)
			{
			CalculRang det_rang_graphe = new CalculRang();
			String nouv_rang_graphe = det_rang_graphe.Rang(tableauGraphePourAlex); ///////////////////////:calcul de rang ////////////////////////
			dataUtiliser.Ecriture_Preuve(nouv_rang_graphe);
			}
			break;
		default:
			break;
		}
		
		
	}
private void niveau2(Enregistrement data)throws FileNotFoundException {
	Enregistrement dataUtiliser = data;
	niveau1(dataUtiliser);
	
	
	switch (dataUtiliser.getType()) {
	case "contraite":
	
		////////////////////////////////////////////////////////////////:calcul de marge a ajouter ////////////////////////
		
		break;
	case "graph": 
	
		ArrayList<String> tmpgraph = dataUtiliser.Lecture_Spesifique();
		System.out.println(tmpgraph);
		int Nbsommetsgraph= Integer.parseInt(tmpgraph.get(0));
		String tabfingraph[][]= new String[Integer.parseInt(tmpgraph.get(1))+2][];
		tabfingraph[0] = new String[1];
		tabfingraph[1] = new String[1];
		
		for(int i=2;i<tmpgraph.size();i++) {
			tabfingraph[i] = new String[3];
			String tabTmp[]=tmpgraph.get(i).split("\n");
			for(int j=2;j<3;j++) {
				tabfingraph[i]=tabTmp[j-2].split(" ");

			}
		}
		tabfingraph[0][0]= tmpgraph.get(0);
		tabfingraph[1][0]= tmpgraph.get(1);

		
		System.out.println("///////Tableau de graph dont a besoin Adrien : ////////////");
		for(int i = 0 ; i < tabfingraph.length; i++)
		{
			for(int j = 0; j<tabfingraph[i].length;j++)
			{
				System.out.print(tabfingraph[i][j]+"		");
			}
			System.out.println("\n");
		}
		
		////////////////////////////////////////////////////////////////////////////////////               A SUPRIMER !!!!!!!!!!!!!!!!!!!!!!!!!
		
		int rangmax= 4;////////////////////////////////////variable a fournir par alexandre : rangmax 
		int rang[]={1,0,1,3,2,2}; /////////////////////////variable a fournir par alexandre : rang[] 
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String tableauDeGraphe[][]=tabfingraph;
		UnPointEntrerEtUnPointSortie Un = new UnPointEntrerEtUnPointSortie(tableauDeGraphe,rang,rangmax);
		String un= Un.verife2Tab();
		if (un.contains("Erreur")) {
			dataUtiliser.Ecriture_Erreu(un);
		}
		else {
			dataUtiliser.Ecriture_Preuve(un);
		}
		
		ValeurArcGraph V = new ValeurArcGraph(tableauDeGraphe);
		String v= V.verife2Tab();
		if (v.contains("Erreur")) {
			dataUtiliser.Ecriture_Erreu(v);
		}
		else {
			dataUtiliser.Ecriture_Preuve(v);
		}
		
		
		
		break;
	default:
		break;
	}
	
	
	
		
	}
private void niveau3(Enregistrement data)throws FileNotFoundException {
	Enregistrement dataUtiliser = data;
	niveau1(dataUtiliser);
	niveau2(dataUtiliser);
	
	switch (dataUtiliser.getType()) {
	case "contraite":
	
		ArrayList<String> tmp = dataUtiliser.Lecture_Spesifique();
		
		System.out.println(tmp);
		int Nbsommets= Integer.parseInt(tmp.get(0));
		String tabfin[][]= new String[((Nbsommets*2)+1)][];
		tabfin[0] = new String[1];
		for(int i=0 ; i<Nbsommets;i++ ) {
			tabfin[i+1] = new String[2];
		}
		for(int i=Nbsommets ; i<(2*Nbsommets);i++ ) {
			int l;
			l = tmp.size() - tmp.get(i).replace(" ", "").length();
			tabfin[i+1] = new String[l];
		}
		
		for(int i=1;i<tmp.size();i++) {
			
			String tabTmp[]=tmp.get(i).split("\n");
			for(int j=2;j<3;j++) {
				tabfin[i]=tabTmp[j-2].split(" ");

			}
		}
		tabfin[0][0]= tmp.get(0);

		
		System.out.println("///////Tableau de contrainte dont a besoin Adrien : ////////////");
		for(int i = 0 ; i < tabfin.length; i++)
		{
			for(int j = 0; j<tabfin[i].length;j++)
			{
				System.out.print(tabfin[i][j]+"		");
			}
			System.out.println("\n");
		}
		String [] [] tableauDeContrainte = tabfin;
		
		NombreEtNuméroSommet N_et_N_S = new NombreEtNuméroSommet(tableauDeContrainte);
		String nns=N_et_N_S.verife2Tab();
		
		if(nns.contains("Erreur")) {
			dataUtiliser.Ecriture_Erreu(nns);
		}
		else {
			dataUtiliser.Ecriture_Preuve(nns);
		} 
		
		////////////////////////// ajout des sommets a et w si besoin ///////////////////////////////////////////////

		break;
	case "graph": 
	
		////////////////////////// ajout des sommets a et w si besoin ///////////////////////////////////////////////
		
		break;
	default:
		break;
	}
	
	
}
private void niveau4(Enregistrement data)throws FileNotFoundException {
	Enregistrement dataUtiliser = data;
	niveau1(dataUtiliser);
	niveau2(dataUtiliser);
	niveau3(dataUtiliser);
	
	switch (dataUtiliser.getType()) {
	case "contraite":
	
		
		
		break;
	case "graph": 
	
		
		
		
		break;
	default:
		break;
	}
	
	
}
}
