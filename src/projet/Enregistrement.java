package projet;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.text.SimpleDateFormat;

public class Enregistrement {
	private File file;
	private File preuve;
	private File erreu;
	private String type;			//contraite ou graph
	private String[][] DataGraph;
	private String[][] DataContraite;
	private SimpleDateFormat  date= new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss");

	private int nbLine=0;

	public Enregistrement(File fichier, String type) {			//conctructeur spécialiser 
		try {
		this.file = fichier;
		this.type= type;   //contraite ou graph
		this.preuve = new File("Preuve_execution.txt");
		if(!this.preuve.exists()) {
			this.preuve.createNewFile();	
		}
		this.erreu= new File("Erreu.txt");
		if(!this.erreu.exists()) {
			this.erreu.createNewFile();	
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			
		}
			
	}
	
	public Enregistrement(String nomFichier) throws IOException {					// constructeur générale 
		this.file = new File("."+file.separator+nomFichier+".txt");
		if(!file.exists()) 
		{	
				Erreur(file,"pas de fichier");		
		}
			
	}
	/*public Enregistrement(String Path,int preuve0_erreu1)  {		// pour le peuve et erreu 
		try {
			switch(preuve0_erreu1) {
			case 0:
				this.file = new File(Path+file.separator+"Preuve_execution.txt");
				if(!this.file.exists()) {
					this.file.createNewFile();	
				}
				/*PrintWriter printPreveu = new PrintWriter(new FileOutputStream(this.file,true));
				printPreveu.println(Path);
				break;
			case 1:
				this.file = new File(Path+file.separator+"Erreu.txt");
				if(!this.file.exists()) {
					this.file.createNewFile();	
				}
				/*PrintWriter printErreu = new PrintWriter(new FileOutputStream(this.file,true));
				printErreu.println(Path);
				break;
			default:break;
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
	public Enregistrement() {					// constructeur générale 
		this.file = new File("."+file.separator+"preference.txt");
		if(!file.exists()) 
		{	
				file=null;	
		}
			
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean setDataGraph(String[][] data) {
		if(type == "graph") {
			DataGraph = data;
			return true;
		}
		
		return false;
	}
	
	public boolean setDataContraite(String[][] data) {
		if(type == "contraite") {
			DataContraite = data;
			return true;
		}
		
		return false;
	}
	public String[][] getDataGraph(){
		return DataGraph;
	}
	public String[][] getDataContraite(){
		return DataContraite;
	}
	
	public boolean Ecriture_Erreu(String Erreu) throws FileNotFoundException {
		PrintWriter printErreu = new PrintWriter(new FileOutputStream(this.erreu,true));
		
		printErreu.println(date.format(new Date())+" "+type+" : "+Erreu);
		printErreu.close();
		return true;
	}
	public boolean Ecriture_Preuve(String Preuve) throws FileNotFoundException{
		PrintWriter printPreuve = new PrintWriter(new FileOutputStream(this.preuve,true));
		printPreuve.println(date.format(new Date())+" "+type+" : "+Preuve);
		printPreuve.close();
		return true;
		
	}
	
	
	public ArrayList<String> Lecture_Spesifique() throws FileNotFoundException{
		ArrayList<String> tab ;
		if(type == "contraite") {
			String preData =Lecture();
			tab =new ArrayList<String>(Arrays.asList(preData.split("\n")));
			return tab;
		}else if (type == "graph") {
			
			String preData =Lecture();
			tab =new ArrayList<String>(Arrays.asList(preData.split("\n")));
			return tab;
			
		}else {
			return null;
		}
	}
	
	
	public String Lecture() throws FileNotFoundException {  
		String tmp = "";
		Ecriture_Preuve("commancement Lecture\n");
		
		try(FileInputStream fis= new FileInputStream(file)){
			Scanner sc=new Scanner(fis);
			while (sc.hasNextLine()){
			tmp=tmp+sc.nextLine()+"\n";
			}
			fis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return e1.getMessage();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return e1.getMessage();
		}
		return tmp;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////// LECTURE String
	public ArrayList<String> lectureString() {
		ArrayList<String> tabTMP= new ArrayList<>();
		Scanner sc=null;
		System.out.println("commancement Lecture String\n\t"+file.getAbsolutePath());
		try(FileInputStream fis= new FileInputStream(file)){
			sc=new Scanner(fis);
			while (sc.hasNextLine()){
				tabTMP.add(sc.nextLine());
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			if(sc!=null) {
			sc.close();
			}
		}
		return tabTMP;
	}
	/////////////////////////////////////////// ECRITURE STRING ARRAY
	
	public boolean Ecritue(ArrayList<String> text) throws IOException {
		
		try(PrintWriter print = new PrintWriter(new FileOutputStream(file))) {
			for (int i=0;i<text.size();i++) {
				print.println(text.get(i));
				
			}
			print.close();
		} catch (IOException e1) {
			Erreur(file, e1.getMessage());
			e1.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}
	/////////////////////////////////////////////////// ECRITURE STRING ARRAY
	
	public boolean Ecriture(String change) throws IOException {
		
		ArrayList<String> changemen=lectureString();
		
		//changemen.add(change);
		try(PrintWriter print = new PrintWriter(new FileOutputStream(file))) {
			for (int i = 0; i < changemen.size(); i++) {
				print.println(changemen.get(i));
			}
			print.println(change);
			print.close();
		} catch (IOException e1) {
			Erreur(file, e1.getMessage());
			return false;
			// TODO: handle exception
		}finally {
			
		}
		return true;
	}
	
private boolean Erreur(File fic,String txt)throws IOException {
		
		File nomFichier1 = new File("erreur.txt");
		if(!nomFichier1.exists()) {
			nomFichier1.createNewFile();
		}
		PrintWriter print = new PrintWriter(new FileOutputStream(nomFichier1,true));
		print.println(txt+" "+fic.getPath());
		//CreationDesFichier();
		return true;
		
	}


	
	////////////////////////////////////////////////////////////////////////////////////////////////////// Changement 
/*
	
	private void CreationDesFichier() throws IOException {
		File fichierClient = new File("."+File.separator+"test.txt");
		File fichierVehicule = new File("."+File.separator+"Véhicule.txt");
		File fichierAide = new File("."+File.separator+"aide.txt");
			if(!fichierClient.exists()) {
		fichierClient.createNewFile();
		
		PrintWriter printClient = new PrintWriter(new FileOutputStream(fichierClient,true));
		printClient.println("0/Panthou/Jean/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("1/Brochard/Guillaume/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("2/Panthou/Pierre/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("3/Snaej/N Co/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("4/Orange/Innocent/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("5/Pas/D'idée/37-rue-1400-ville/15 2 1995-5 6 2018");
		printClient.println("6/Pourquoi/Pas/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("7/Windows/Mac/37-rue-1400-ville/15 2 1995-5 12 2018");
		printClient.println("8/ger/ve/1-vre-1000-vr/11 1 2018-12 1 2018");
		printClient.print("9/er/errve/1-er-1000-vrerv/11 1 2018-12 1 2018");
		printClient.close();
			}
			if (!fichierVehicule.exists()) {
		fichierVehicule.createNewFile();
		PrintWriter printVehicule = new PrintWriter(new FileOutputStream(fichierClient,true));
		printVehicule.println("0/M/150/Yamana/-1");
		printVehicule.println("1/A/150/Renaud/1");
		printVehicule.println("2/M/150/Yamana/-1");
		printVehicule.println("3/A/X3615/Yamana/-1");
		printVehicule.println("4/A/tata/Fiat/-1");
		printVehicule.println("5/M/250/SNC/6");
		printVehicule.println("6/A/X250/Lexuc/-1");
		printVehicule.println("7/M/720/Honda/-1");
		printVehicule.println("8/M/250/Yamana/-1");
		printVehicule.println("9/A/tata2/Fiat/-1");
		printVehicule.print("10/A/drtfgy/cfgv/-1");
		printVehicule.close();
			}
		if(!fichierAide.exists()) {
			fichierAide.createNewFile();
			PrintWriter printAide =new PrintWriter(new FileOutputStream(fichierAide,true));
			printAide.println("Nom commun :\r\n" + 
					"Action d’apporter son soutien physiquement, verbalement,\r\n" + 
					"financièrement ou de tout autre manière.\r\n" + 
					"À la fois la personne dont on reçoit du secours et le \r\n" + 
					"soutien que l’on en tire.\r\n" + 
					"Secours que procurent certaines choses.\r\n" + 
					"(Administration) (Religion catholique) Se disait d’une \r\n" + 
					"église, d’une chapelle qui servait de \r\n" + 
					"succursale à une église paroissiale dont les habitants \r\n" + 
					"étaient trop éloignés,\r\n" + 
					"(Histoire) (Au pluriel) Impôts levés sur les denrées \r\n" + 
					"et marchandises qui se vendaient et se \r\n" + 
					"transportaient dans toute l’étendue du royaume.\r\n" + 
					"(Équitation) Moyens que le cavalier emploie pour bien \r\n" + 
					"manier un cheval, et plus particulièrement \r\n" + 
					"des mains et des jambes dans leur action sur le cheval.\r\n" + 
					"(Architecture) petites pièces ménagées près des grandes\r\n" + 
					" pièces d’apparat ou de service qui ont \r\n" + 
					"besoin de dégagement.\r\n" + 
					"\r\n" + 
					"Nom commun :\r\n" + 
					"Personne qui est auprès de quelqu’un pour travailler ou\r\n" + 
					" servir conjointement avec lui et sous sa \r\n" + 
					"responsabilité.");
			printAide.close();			
		}

	}*/
	

	
	
	

}
