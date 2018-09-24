package projet;

import java.util.concurrent.ExecutionException;

public class ManipulationTab {
	
	private String[][] tabToMani;
	private int colone , ligne;
	
	public ManipulationTab(String[][] tab) throws SaisieErroneeException {
		if(!tab.equals(null) || tab.length!=0) {
		colone=tab.length;
		ligne= tab[0].length;
		tabToMani=tab;
		}
		else {
			
			throw new SaisieErroneeException("tableau null ou vide");
		}
	}
	
	public String[][] RajouterColoneDebut(){
		String newTab[][]=new String[colone+1][ligne];
		initTabA_X(newTab);
		
		for (int i=1; i<colone;i++) {  
			for(int j=0;j<ligne;j++) {
				newTab[i-1][j]=tabToMani[i][j];
				
			}
		}
		tabToMani = newTab;
		return newTab;
	}
	
	public String[][] RajouterLigneDebut(){
		String newTab[][]=new String[colone][ligne+1];
		initTabA_X(newTab);
		
		for (int i=0; i<colone;i++) {  
			for(int j=1;j<ligne;j++) {
				newTab[i][j-1]=tabToMani[i][j];
				
			}
		}
		tabToMani = newTab;
		return newTab;
	}
	
	private void initTabA_X(String[][] tmp) {
		int colone1=tmp.length ,ligne1=tmp[0].length;
		
		for (int i=0; i<colone1;i++) {  
			for(int j=0;j<ligne1;j++) {
				tmp[j][i]="X";
				
			}
			
		}
	}
	
	public String[] fusionLigneColone(String[][] tmp) {
		String tabTmp[]=new String[tmp.length];
		
		for(int j=1;j<tmp.length;j++) {
			
			tabTmp[j-1]=tmp[0][j]+tmp[j][0];

		}
		
		
		return tabTmp;
	}

}
