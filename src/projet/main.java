package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class main extends JFrame {

	private JPanel contentPane;
	private Enregistrement file;
	private Open_File tmp;
	private JTextField test;
	private int test_Activation=0;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Mini projet de manipulation de graphe");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Snaej & Co\\eclipse-workspace\\theorie des graphe\\img\\th\u00E9orie des graphe.png"));
		
		
		///////////////////////   Variable qui regroupe les donner qu'il nous faut
		
		
		
		
		
		
		
		///////////////////////////////////////
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 605, 26);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(mnFile);
		
		JMenuItem mntmOuvrire = new JMenuItem("ouvrire");
		mnFile.add(mntmOuvrire);
		
		JMenu mnCalcule = new JMenu("Calcule");
		mnCalcule.setIcon(new ImageIcon(main.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		//menuBar.add(mnCalcule);
		
		test = new JTextField();
		test.setBounds(22, 96, 116, 22);
		contentPane.add(test);
		test.setColumns(10);
		JSpinner spNiv = new JSpinner();
		spNiv.setEnabled(false);
		
	
		
        table = new JTable();
      
	
		//table.setBounds(241, 63, 362, 259);
		
		
		JButton btnRafre = new JButton("rafr\u00E9chisement");
		btnRafre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(test_Activation==1&&tmp.getData_Brute()!=null)
					test.setText(tmp.getData_Brute().getFile().getName());
					file =tmp.getData_Brute();
					spNiv.setEnabled(true);
					ArrayList<String> tabGraph = new ArrayList<>();
					try {
						tabGraph = file.Lecture_Spesifique();
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(contentPane,e.getMessage()+"\n"+e.getLocalizedMessage(),"Erreu",JOptionPane.ERROR_MESSAGE);
					}finally {
						if(tabGraph.isEmpty()) {
						tabGraph= null;
						}
					}
			switch (file.getType()) {
			
			case "contraite":
				if (tabGraph.size()>2 && tabGraph.get(1).indexOf(" ")!=-1&&!tabGraph.isEmpty()) {
				int NbTache= Integer.parseInt(tabGraph.get(0));				//// rajouter un teste ici "fichier vide
				int DureTache[]=new int[NbTache];
				String [] colune= new String[NbTache+2] ;
				
				System.out.println("valeur colone");
				try {
					file.Ecriture_Preuve("valeur colone");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane,e.getMessage()+"\n"+e.getLocalizedMessage(),"Erreu",JOptionPane.ERROR_MESSAGE);
				}
				for(int i=0;i<NbTache;i++) {
					colune[i]= ""+(i+1);
					System.out.println(i+"\t"+colune[i]);
				}
				for(int i=1;i<=NbTache;i++) {
					String tabTmp[]=tabGraph.get(i).split(" ");
					DureTache[Integer.parseInt(tabTmp[0])-1]=Integer.parseInt(tabTmp[1]);
					System.out.println(tabTmp[0]+"\t"+tabTmp[1]);
				}
				table.setModel(new DefaultTableModel(new Object[NbTache+2][NbTache+2],colune));
				String tabfin[][]= new String[NbTache+2][NbTache+2];
				for (int i=0; i<NbTache+2;i++) {  //// teste table 2D 
					for(int j=0;j<NbTache+2;j++) {
						tabfin[j][i]="X";
						table.setValueAt("X", i, j);
					}
					
				}
				tabfin[0][0]="\\";
				table.setValueAt("\\", 0, 0);
				  //// init tableau 2D
					for(int j=1;j<NbTache+2;j++) {
						tabfin[0][j]=""+j;
						table.setValueAt(j, 0, j);
						tabfin[j][0]=""+j;
						table.setValueAt(j, j, 0);
						//table.setValueAt(j, 0, j);
					}
					tabfin[0][NbTache+1]="w";		// colone puis ligne
					table.setValueAt("w", 0, (NbTache+1));
					tabfin[NbTache+1][0]="w";
					table.setValueAt("w", (NbTache+1), 0);
					
					System.out.println("test remplire les valeur");
					for(int i=1+NbTache;i<tabGraph.size();i++) 
					{
						String tabTmp[]=tabGraph.get(i).split(" ");
						//System.out.println("valeur de i"+i+"\n"+tabGraph.get(i));
						for(int j=1;j<tabTmp.length;j++)
						{
							if(!tabTmp[j].equals("0")) 
							{
								tabfin[Integer.parseInt(tabTmp[0])][Integer.parseInt(tabTmp[j])]=""+DureTache[Integer.parseInt(tabTmp[j])-1];
								table.setValueAt(DureTache[Integer.parseInt(tabTmp[j])-1], Integer.parseInt(tabTmp[j]), Integer.parseInt(tabTmp[0]));
							}	
					    }
					}
					for(int i=1;i<NbTache+1;i++) {
						boolean tmp=false;
						for(int j=1;j<NbTache+1;j++) {
							System.out.print("|j = "+j+"\t"+tmp+"|");
							if(tmp==false) {
							if (!tabfin[j][i].equals("X")) {
								tmp=true;
							}
							}
						}
						System.out.println("");
						if(!tmp) {
							tabfin[(NbTache+1)][i]=""+DureTache[(i-1)];
							table.setValueAt(DureTache[(i-1)], i, (NbTache+1));
							
						}
						
					}
					
					System.out.println("Tab contrainte all");
					for (int i=0; i<NbTache+2;i++) {  //// teste table 2D 
						for(int j=0;j<NbTache+2;j++) {
							System.out.print(" "+tabfin[j][i]+" ");
						}
						System.out.println("");
					}
					//////////////////////////////////////////////////////////////  remplicage de DataContaine
					System.out.println("Tab contrainte seulemment data");
					String tabDataTMP[][]= new String[NbTache+1][NbTache+2];
					
					for (int i=1; i<NbTache+1;i++) {
						for(int j=1;j<NbTache+1;j++) {
							tabDataTMP[j-1][i-1]=tabfin[j][i];
							System.out.print(" "+tabDataTMP[j-1][i-1]+" ");
						}
						System.out.println("");
					}
				
				if(!file.setDataContraite(tabDataTMP))
				{
					JOptionPane.showMessageDialog(contentPane,"Mauvais type de fichier\ntype atentdu containte","Erreu",JOptionPane.ERROR_MESSAGE);
				}
				String[][] erui=file.getDataContraite();
				/*System.out.println("teste\t"+erui.length);
				for (int i=0; i<erui.length-1;i++) {  //// teste table 2D 
					for(int j=0;j<erui.length-1;j++) {
						System.out.print(" "+erui[j][i]+" ");
					}
					System.out.println("");
				}*/
				Sommer tmp =new Sommer(erui);
				contentPane.add(table);
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"mauvais fichier ","Erreu",JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "graph":
				if (tabGraph.size()>2 && tabGraph.get(1).indexOf(" ")==-1&&!tabGraph.isEmpty()) {
				int Nbsommets= Integer.parseInt(tabGraph.get(0));
				int NbArcs= Integer.parseInt(tabGraph.get(1));
				String [] colune= new String[Nbsommets] ;
				for(int i=0;i<Nbsommets;i++) {
					colune[i]= ""+i;
				}
				table.setModel(new DefaultTableModel(new Object[Nbsommets][Nbsommets],colune));
				String tabfin[][]= new String[Nbsommets][Nbsommets];
				for (int i=0; i<Nbsommets;i++) {  //// init tableau 2D
					for(int j=0;j<Nbsommets;j++) {
						tabfin[j][i]="X";
						table.setValueAt("X", i, j);
					}
				}
				for(int i=2;i<tabGraph.size();i++) {
					String tabTmp[]=tabGraph.get(i).split(" ");
					System.out.println("tabGrag "+tabGraph.get(i)+"\ntabTmp a"+i+":\t"+tabTmp[0]+" - "+tabTmp[1]+" - "+tabTmp[2]);
					tabfin[Integer.parseInt(tabTmp[1])][Integer.parseInt(tabTmp[0])]=tabTmp[2];
					table.setValueAt(tabTmp[2], Integer.parseInt(tabTmp[0]), Integer.parseInt(tabTmp[1]));
				}
				for (int i=0; i<Nbsommets;i++) {  //// teste table 2D 
					for(int j=0;j<Nbsommets;j++) {
						System.out.print("|"+tabfin[j][i]+"|");
					}
					System.out.println("");
				}
				
				Sommer test=new Sommer(tabfin);
					
				if(!file.setDataGraph(tabfin))
				{
					JOptionPane.showMessageDialog(contentPane,"Mauvais type de fichier\ntype atentdu Graph","Erreu",JOptionPane.ERROR_MESSAGE);
				}
				
				  
				contentPane.add(table);
				/*//////////////////////////////////////////////////////   teste  des donner récupére affichage console
				System.out.println(file.getType()+
						"\n Nb Sommé \t"+Nbsommets
						+"\n Nb Arc \t"+NbArcs
						+"\n Nb dans colune \t"+colune.length);
				for (int i = 0; i < colune.length; i++) {
					System.out.println(colune[i]);
				}
						System.out.println("\n"+tabGraph.toString());	
					for (int i=0; i<NbArcs;i++) {  //// teste table 2D 
						for(int j=0;j<Nbsommets;j++) {
							System.out.print("|"+tabfin[j][i]+"|");
						}
						System.out.println("");
					}
						////////////////////////////////////////////////////////////            fin du test*/
				}
				else {
					if(tabGraph.get(1).indexOf(" ")==-1) {
						JOptionPane.showMessageDialog(contentPane,"mauvais fichier \nou presence d'un espace a la 2eme ligne","Erreu",JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(contentPane,"fichier corrompue","Erreu",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				break;

			default:
				JOptionPane.showMessageDialog(contentPane,"erreur fichier L155 - Type","Erreu",JOptionPane.ERROR_MESSAGE);
				break;
			}
			spNiv.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent arg0) {
					int niveau = (Integer)spNiv.getValue();
					try {
						Calcule tmp =new Calcule(file, niveau);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane,e.getMessage()+"\n"+e.getLocalizedMessage(),"Erreu",JOptionPane.ERROR_MESSAGE);
					}
					
				}});
			
		

		
			}});
		
		
		btnRafre.setBounds(12, 58, 124, 25);
		contentPane.add(btnRafre);
		
		table_2 = table;
		table_2.setBounds(150, 58, 443, 291);
		contentPane.add(table_2);
		
		
		spNiv.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spNiv.setBounds(22, 156, 116, 22);
		contentPane.add(spNiv);
		
		JLabel lblNewLabel = new JLabel("Niveau");
		lblNewLabel.setBounds(22, 131, 116, 16);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		mntmOuvrire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
				 tmp= new Open_File();
				 test_Activation=1;
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(contentPane,e1.getMessage()+"\n"+e1.getLocalizedMessage(),"Erreu",JOptionPane.ERROR_MESSAGE);		
				

			}	
				
			}
		});


		
	
		
		
	}
}
