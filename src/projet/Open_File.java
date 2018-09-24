package projet;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Open_File extends JFrame {

	public Enregistrement getData_Brute() {
		if (data_Brute != null) {
			return data_Brute;
		}else {
			return null;
		}
		
	}

	public void setData_Brute(Enregistrement data_Brute) {
		this.data_Brute = data_Brute;
	}

	public JFrame frame;
	private JPanel contentPane;
	private File Lefile;
	private String type;
	private Enregistrement data_Brute;

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Open_File frame = new Open_File();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	*/
	
	public Open_File()throws IOException {
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(Open_File.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		setTitle("Open File");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 544);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//setLayout(null);
		Enregistrement testFun = new Enregistrement();
		JFileChooser fileChooser;
		if(testFun.getFile()!=null) {
			fileChooser = new JFileChooser(testFun.getFile());
		
			System.out.println(testFun.getFile().getAbsolutePath());
		}else {
			fileChooser = new JFileChooser();
		}
				
				fileChooser.setVisible(false);
				JRadioButton fileGraph = new JRadioButton("Fichier Graphe");
				fileGraph.setForeground(Color.BLACK);
				JRadioButton fileContraite = new JRadioButton("Fichier Contraite");
				fileContraite.setSelected(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "text", "txt", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.addChoosableFileFilter(new MyFilter());
				fileChooser.setVisible(true);
				
					fileContraite.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(fileContraite.isSelected() == true) {
								fileChooser.setVisible(true);
								fileGraph.setSelected(false);
								
								type="contraite";
							}
						}
					});
					fileGraph.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (fileGraph.isSelected() == true) {
								fileChooser.setVisible(true);
								fileContraite.setSelected(false);
							
								type="graph";
							}
						}
					});
					
				ActionListener actionListener=  new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 JFileChooser theFileChooser = (JFileChooser)e.getSource();
					        String command = e.getActionCommand();
					        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
					       	 Lefile = theFileChooser.getSelectedFile();
					          if(!type.isEmpty()) {
								data_Brute=new Enregistrement(Lefile, type);
					          }
					         setVisible(false);

					        }  else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
					         dispose();
					        }
						
					}
				};
				
				fileChooser.addActionListener(actionListener);
				
				fileGraph.setBounds(5, 5, 142, 25);
				contentPane.setLayout(null);
				fileContraite.setBounds(158, 5, 127, 25);
				getContentPane().add(fileContraite);
				getContentPane().add(fileGraph);
				
				//FileFilter filtre = new FileNameExtensionFilter("txt files", "txt");
				//fileChooser.addChoosableFileFilter(filter);
				fileChooser.setMultiSelectionEnabled(true);
				fileChooser.setBounds(5, 30, 684, 464);
				getContentPane().add(fileChooser);
	}
	
	class MyFilter extends javax.swing.filechooser.FileFilter {
		  public boolean accept(File file) {
		    String filename = file.getName();
		    return filename.endsWith(".txt");
		  }

		  public String getDescription() {
		    return "*.txt";
		  }
	}
}
