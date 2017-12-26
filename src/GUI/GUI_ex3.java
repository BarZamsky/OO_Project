package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
=======
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import Project.Records;
import Project.Filter_Your_File;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project

<<<<<<< HEAD
import java.awt.Font;
import Project.Records;
import Project.Point_2D;
import Project.LineFile;
import Project.Network;
import Project.Filter_Your_File;
import Project.Time;

public class GUI_ex3 extends JFrame implements ActionListener {

=======
public class GUI_ex3 extends JFrame implements ActionListener {
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
	private JFrame frame;
<<<<<<< HEAD
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
=======
	private Records _rec ;
	private JTextField textField;
	private JTextField textField2;
	 String fileName="";
	 String folderName="";
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Records r = new Records();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ex3 window = new GUI_ex3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public GUI_ex3() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("OOP \u2665");
		frame.setBounds(0, -65, 935, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
<<<<<<< HEAD
		 ImageIcon algo = new ImageIcon("algorithm.png");
		 ImageIcon csv = new ImageIcon("csv.png");
		 ImageIcon delete = new ImageIcon("delete.png");
		 ImageIcon file = new ImageIcon("file.png");
		 ImageIcon filter = new ImageIcon("filter.png");
		 ImageIcon folder = new ImageIcon("folder.png");
		 ImageIcon kml = new ImageIcon("kml.png");
		 ImageIcon info = new ImageIcon("info.png");
		 
		 ////csv file name buttom////
		JButton b1 = new JButton("Name of CSV file",file);
		b1.setFont(new Font("Gisha", Font.PLAIN, 22));
	    b1.setMnemonic(KeyEvent.VK_D);
	    b1.setActionCommand("enter csv name :");
		b1.setBounds(42, 138, 253, 37);
		frame.getContentPane().add(b1);
	    b1.setActionCommand("enable");
	    b1.setEnabled(true);
	    textField = new JTextField(20);
	    textField.addActionListener(this);
	    textArea = new JTextArea(5, 20);
	    scrollPane = new JScrollPane(textArea); 
	    textArea.setEditable(false);
		b1.addActionListener(this);
add(textField);		
		////name of folder to read////
		JButton b2 = new JButton("Name of folder",folder);
		b2.setFont(new Font("Gisha", Font.PLAIN, 22));
		b2.setBounds(42, 77, 253, 37);
		frame.getContentPane().add(b2);
		JButton b3 = new JButton("  Information",info);
		b3.setFont(new Font("Gisha", Font.PLAIN, 22));
		b3.setActionCommand("enable");
	    b3.setEnabled(true);
	    b3.setBounds(42, 260, 253, 37);
		frame.getContentPane().add(b3);
		b3.addActionListener(this);
=======
		ImageIcon csv = new ImageIcon("csv.png");
		ImageIcon delete = new ImageIcon("delete.png");
		ImageIcon file = new ImageIcon("file.png");
		ImageIcon folder = new ImageIcon("folder.png");
		ImageIcon kml = new ImageIcon("kml.png");
		ImageIcon info = new ImageIcon("info.png");

		//define the main buttons

		JPanel algo_panel = new JPanel();
		JPanel filter_panel = new JPanel();
		JPanel IOpanel = new JPanel();
		IOpanel.setBackground(Color.WHITE);
		IOpanel.setBounds(193, 40, 692, 404);
		frame.getContentPane().add(IOpanel);
		IOpanel.setLayout(null);

		//all the buttons inside I/O
		textField = new JTextField("");
		textField.setVisible(true);
		IOpanel.add(textField);

		JButton btnNameOfScv = new JButton("Name of CSV file",file);
		btnNameOfScv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setBounds(195, 58, 159, 35);
				textField.setBackground(Color.PINK);
				textField.setColumns(20);
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent evt) {
						if(evt.getKeyCode()==KeyEvent.VK_ENTER){
					        fileName = textField.getText();
							textField.setVisible(false);
						}
					}
				});
			}
		});

		btnNameOfScv.setBounds(14, 5, 224, 35);
		IOpanel.add(btnNameOfScv);
		btnNameOfScv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfScv.setVisible(true);
		btnNameOfScv.setActionCommand("enable");
		btnNameOfScv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		}});
		
//////folder//////
		textField2 = new JTextField("");
		textField2.setVisible(true);
		IOpanel.add(textField2);
		JButton btnNameOfFolder = new JButton("Name of folder",folder);
		btnNameOfFolder.setBounds(14, 99, 224, 35);
		IOpanel.add(btnNameOfFolder);
		btnNameOfFolder.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfFolder.setActionCommand("enable");

		btnNameOfFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNameOfFolder.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						textField2.setBounds(195, 150, 159, 35);
						textField2.setBackground(Color.PINK);
						textField2.setColumns(20);
						textField2.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent evt) {
								if(evt.getKeyCode()==KeyEvent.VK_ENTER){
									folderName = textField2.getText();
									textField2.setVisible(false);
								}
							}
						});
					}
				});
			}
		});
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
		
<<<<<<< HEAD
		//////delete the record//////
		JButton b4 = new JButton("  Delete",delete);
		b4.setFont(new Font("Gisha", Font.PLAIN, 22));
		b4.setBounds(42, 199, 253, 37);
		b4.setActionCommand("enable");
	    b4.setEnabled(true);
		frame.getContentPane().add(b4);
		b4.addActionListener(this);
	
		//// save merge to kml ////
		JButton b5 = new JButton("Save as KML file",kml);
		b5.setFont(new Font("Gisha", Font.PLAIN, 22));
		b5.setBounds(365, 138, 253, 37);
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("Save as comb CSV",csv);
		b6.setFont(new Font("Gisha", Font.PLAIN, 22));
		b6.addActionListener(new ActionListener() {
=======
////////info////////
		JButton btnInformation = new JButton("  Information",info);
		btnInformation.setBounds(404, 5, 159, 35);
		IOpanel.add(btnInformation);
		btnInformation.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnInformation.setActionCommand("enable");
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("enable".equals(e.getActionCommand())){
					System.out.println(_rec.getSize());
				}
			}
		});

		JButton btnDelete = new JButton("  Delete",delete);
		btnDelete.setBounds(568, 5, 109, 35);
		IOpanel.add(btnDelete);
		btnDelete.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnSaveAsKml = new JButton("Save as KML file",kml);
		btnSaveAsKml.setBounds(22, 224, 216, 35);
		IOpanel.add(btnSaveAsKml);
		btnSaveAsKml.setActionCommand("enable");
		btnSaveAsKml.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveAsKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("enable".equals(e.getActionCommand())){
					_rec.csv2Kml(fileName+".kml");
				}
			}
		});

		////////////
		JButton btnSaveCombCsv = new JButton("Save as comb CSV",csv);
		btnSaveCombCsv.setBounds(14, 331, 256, 35);
		IOpanel.add(btnSaveCombCsv);
		btnSaveCombCsv.setFont(new Font("Gisha", Font.PLAIN, 22));

		btnSaveCombCsv.setActionCommand("enable");
		btnSaveCombCsv.addActionListener(new ActionListener() {
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
			public void actionPerformed(ActionEvent e) {
				if("enable".equals(e.getActionCommand())){
					_rec = new Records();
					_rec.parseFile(folderName);
					_rec.toCsv(fileName+".csv");
				}
			}
<<<<<<< HEAD
		});   
		
		b6.setBounds(365, 77, 253, 37);
		frame.getContentPane().add(b6);
		 
		JLabel lblNewJgoodiesTitle = new JLabel("OOP_Ex3");
		lblNewJgoodiesTitle.setFont(new Font("Gisha", Font.BOLD, 26));
		lblNewJgoodiesTitle.setBounds(260, 24, 200, 29);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		 
		JButton b7 = new JButton("  Filters",filter);
		b7.setFont(new Font("Gisha", Font.PLAIN, 22));
		b7.setBounds(365, 199, 253, 37);
		frame.getContentPane().add(b7);
		
		JButton b8 = new JButton("  Algorithms",algo);
		b8.setFont(new Font("Gisha", Font.PLAIN, 22));
		b8.addActionListener(new ActionListener() {
=======
		});
		/////////////////////////////////////
		/**
		 * algorithm_pannel 
		 */

		algo_panel.setBackground(Color.WHITE);
		algo_panel.setBounds(193, 40, 692, 404);
		frame.getContentPane().add(algo_panel);

		JButton btnAlgorithms = new JButton("Algorithms");
		btnAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo_panel.setVisible(true);
				filter_panel.setVisible(false);
				IOpanel.setVisible(false);
			}
		});


		//all the buttons inside algorithms

		JButton btnAlgorithm = new JButton("algorithm 1");
		btnAlgorithm.setBounds(76, 52, 199, 111);
		btnAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		algo_panel.setLayout(null);
		algo_panel.add(btnAlgorithm);

		JButton btnAlgorithm_1 = new JButton("algorithm 2");
		btnAlgorithm_1.setBounds(340, 227, 214, 111);
		algo_panel.add(btnAlgorithm_1);

		/**
		 * filter_pannel
		 */
		JButton btnNewButton_3 = new JButton("Filters");
		filter_panel.setBackground(Color.WHITE);
		filter_panel.setBounds(193, 40, 692, 404);
		frame.getContentPane().add(filter_panel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter_panel.setVisible(true);
				IOpanel.setVisible(false);
				algo_panel.setVisible(false);
			}
		});

		//all the buttons inside filter

		JToggleButton btnNewButton = new JToggleButton("Time");
		filter_panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Location");
		btnNewButton_1.addActionListener(new ActionListener() {
>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
			public void actionPerformed(ActionEvent e) {
			}
		});
<<<<<<< HEAD
		b8.setFont(new Font("Gisha", Font.PLAIN, 22));
		b8.setBounds(365, 258, 253, 37);
		frame.getContentPane().add(b8);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("enable".equals(e.getActionCommand())){
			System.out.println("hi");
		String text = textField.getText();
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textField.selectAll(); 
		}
=======

		filter_panel.add(btnNewButton_1);

		JButton btnDevice = new JButton("Device");
		filter_panel.add(btnDevice);

		JButton btnSaveFilter = new JButton("Save Filter");
		filter_panel.add(btnSaveFilter);

		JButton btnDeleteFilter = new JButton("Delete Filter");
		filter_panel.add(btnDeleteFilter);

		/**
		 * I/O_pannel
		 */

		JButton btnNewButton_2 = new JButton(" I/O");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\noytvili\\git\\OO_Project\\output.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IOpanel.setVisible(true);
				filter_panel.setVisible(false);
				algo_panel.setVisible(false);
			}
		});


		btnNewButton_2.setBounds(11, 92, 179, 73);
		frame.getContentPane().add(btnNewButton_2);


		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\noytvili\\git\\OO_Project\\filter.png"));
		btnNewButton_3.setBounds(11, 201, 179, 73);
		frame.getContentPane().add(btnNewButton_3);


		btnAlgorithms.setIcon(new ImageIcon("C:\\Users\\noytvili\\git\\OO_Project\\algorithm.png"));
		btnAlgorithms.setBounds(11, 310, 179, 73);
		frame.getContentPane().add(btnAlgorithms);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

>>>>>>> branch 'master' of https://github.com/BarZamsky/OO_Project
	}
}
