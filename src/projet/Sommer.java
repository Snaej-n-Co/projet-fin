package projet;

import java.util.ArrayList;

public class Sommer {
	class ValSommer{
		private int nomSom;
		private ArrayList<Integer> NbDepart;
		private ArrayList<Integer> NbArriver;
		public ValSommer(int NOM) {
			nomSom=NOM;
			NbDepart= new ArrayList<>();
			NbArriver= new ArrayList<>();
			
		}
		public int getNomSom() {
			return nomSom;
		}
		public void setNomSom(int nomSom) {
			this.nomSom = nomSom;
		}
		public ArrayList<Integer> getNbDepart() {
			return NbDepart;
		}
		public void setNbDepart(ArrayList<Integer> nbDepart) {
			NbDepart = nbDepart;
		}
		public ArrayList<Integer> getNbArriver() {
			return NbArriver;
		}
		public void setNbArriver(ArrayList<Integer> nbArriver) {
			NbArriver = nbArriver;
		}
		public void addNbArriver(int arrive) {
			NbArriver.add(arrive);
		}
		public void addNbDepart(int nbDepart) {
			NbDepart.add(nbDepart);
		}
		

		
		
	}
	
	private ArrayList<ValSommer> tabSommer= new ArrayList<>();
	
	public Sommer(String[][] tabData) {
		int NbCol = tabData.length;
		for(int i=0;i<NbCol;i++) {
			ValSommer tmp=new ValSommer(i);
			tabSommer.add(tmp);
		}
		for (int i=0; i<NbCol-1;i++) {  
			for(int j=0;j<NbCol-1;j++) {
				if(!tabData[i][j].equals("X")) {
					tabSommer.get(i).addNbArriver(j);
					tabSommer.get(j).addNbDepart(i);
				}
				
			}
		}
		/////////////////  test
		for (int i=0; i<NbCol;i++) {  
					System.out.println("sommer "+tabSommer.get(i).getNomSom()+"\t Depart : "+tabSommer.get(i).getNbDepart()+"\tArriver : "+tabSommer.get(i).getNbArriver());
		}
		
	}
	

}
