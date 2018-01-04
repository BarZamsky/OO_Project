package GUI;

import Project.Algo_1;

import Project.LineFile;
import Project.Records;
import GUI.Choose_folder;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.awt.*;
import Filters.filter_Rec;
import javax.swing.*;
import javax.swing.border.LineBorder;

import GUI.algo2;
/**
 * This class is the main GUI class to our project
 * @author Bar,Noy, Doriya
 *
 */
public class GUI_ex3{
	private JFrame frame;
	private Records _rec ;
	private JTextField textField;
	private String fileName="";
	private String start="",start2="";
	private String end="",end2="";
	private String model="",model1="";
	private double alt=0,lat=0,lon=0,radius=0;
	private String algo1name="";
	private String algo2name="";
	private String comb="";
	private String filter="";
	private boolean not=false;
	private boolean not1=false;
	private filter_Rec _filter;
	private String gate = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		ImageIcon csv = new ImageIcon("icons_GUI\\csv.png");
		ImageIcon delete = new ImageIcon("icons_GUI\\delete.png");
		ImageIcon file = new ImageIcon("icons_GUI\\file.png");
		ImageIcon folder = new ImageIcon("icons_GUI\\folder.png");
		ImageIcon kml = new ImageIcon("icons_GUI\\kml.png");
		ImageIcon info = new ImageIcon("icons_GUI\\info.png");
		/////////////////////////////////////
		/**
		 * I/0 panel
		 */
		JPanel IOpanel = new JPanel();
		IOpanel.setBorder(new LineBorder(new Color(0, 153, 0)));
		IOpanel.setBackground(Color.WHITE);
		IOpanel.setBounds(218, 40, 667, 404);
		frame.getContentPane().add(IOpanel);
		IOpanel.setVisible(true);

		textField = new JTextField("");
		textField.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
		IOpanel.setLayout(null);
		IOpanel.add(textField);

		///buttons name:
		JButton btnNameOfScv = new JButton("Name of CSV file",file);
		JButton btnNameOfFolder = new JButton("Choose folder",folder);
		JButton btnInformation = new JButton("  Information",info);
		JButton btnDelete = new JButton("  Delete the file",delete);
		JButton btnSaveCombCsv = new JButton("Save as comb CSV",csv);
		JButton btnSaveAsKml = new JButton("Save as KML file",kml);

		///name csv file ///
		btnNameOfScv.setBounds(14, 5, 261, 35);
		btnNameOfScv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setBounds(70, 58, 159, 35);
				textField.setBackground(Color.WHITE);
				textField.setColumns(20);
				btnDelete.setEnabled(false);
				btnInformation.setEnabled(false);
				btnNameOfFolder.setEnabled(false);
				btnSaveAsKml.setEnabled(false);
				btnSaveCombCsv.setEnabled(false);
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent evt) {
						if(evt.getKeyCode()==KeyEvent.VK_ENTER){
							fileName = textField.getText();
							textField.setVisible(false);
							btnDelete.setEnabled(true);
							btnInformation.setEnabled(true);
							btnNameOfFolder.setEnabled(true);
							btnSaveAsKml.setEnabled(true);
							btnSaveCombCsv.setEnabled(true);
						}
					}
				});
				textField.setVisible(true);
			}
		});

		IOpanel.add(btnNameOfScv);
		btnNameOfScv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfScv.setVisible(true);

		//////folder//////
		btnNameOfFolder.setBounds(14, 99, 261, 35);
		IOpanel.add(btnNameOfFolder);
		btnNameOfFolder.setFont(new Font("Gisha", Font.PLAIN, 22));

		Choose_folder panel = new Choose_folder();
		btnNameOfFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNameOfFolder.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JFrame frame = new JFrame("");
						frame.getContentPane().add(panel,"Center");
						frame.setSize(panel.getPreferredSize());
						frame.setVisible(true);
					}
				});
			}
		});

		////////info////////
		btnInformation.setBounds(400, 98, 261, 36);
		IOpanel.add(btnInformation);
		btnInformation.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numR = _rec.getSize();
				JOptionPane.ICON_PROPERTY.toString();
				JOptionPane.showMessageDialog(null, "You captured "+numR+" records");
				int routers = 0;
				for(int i=0;i<_rec.getSize();i++){
					LineFile line = _rec.get_rec().get(i);
					routers+=line.getNumOfNetworks();
				}
				JOptionPane.showMessageDialog(null, "You captured "+routers+" routers total in all the scans");
			}
		});

		/////delete button /////
		btnDelete.setBounds(400, 5, 261, 35);
		IOpanel.add(btnDelete);
		btnDelete.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_rec = new Records();
				File file =new File(fileName+".csv");
				file.delete();
				JOptionPane.showMessageDialog(null, "Your file was deleted!\nYou can scan again");
			}
		});

		///// kml /////
		btnSaveAsKml.setBounds(14, 216, 261, 35);
		IOpanel.add(btnSaveAsKml);
		btnSaveAsKml.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveAsKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_rec.csv2Kml(fileName+".kml");
				JOptionPane.showMessageDialog(null, "Your KML file is ready!");
			}
		});

		///// merge csv /////
		btnSaveCombCsv.setBounds(14, 323, 261, 35);
		IOpanel.add(btnSaveCombCsv);
		btnSaveCombCsv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveCombCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_rec = new Records();
				_rec.parseFile((String)panel.chooser.getSelectedFile().getPath());
				_rec.toCsv(fileName+".csv");
				JOptionPane.showMessageDialog(null, "Your CSV file is ready!");
			}
		});

		// define algo panel and filter panel
		JPanel algo_panel = new JPanel();
		algo_panel.setVisible(false);
		algo_panel.setBorder(new LineBorder(new Color(0, 153, 0)));
		algo_panel.setBackground(Color.WHITE);
		algo_panel.setBounds(218, 40, 667, 404);
		frame.getContentPane().add(algo_panel);

		JPanel filter_panel = new JPanel();
		filter_panel.setBorder(new LineBorder(new Color(204, 51, 153)));
		filter_panel.setVisible(false);
		filter_panel.setBackground(Color.WHITE);
		filter_panel.setBounds(218, 40, 667, 404);
		frame.getContentPane().add(filter_panel);
		filter_panel.setLayout(null);
		/////////////////////
		JButton btnAlgorithms = new JButton("Algorithms");
		btnAlgorithms.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo_panel.setVisible(true);
				filter_panel.setVisible(false);
				IOpanel.setVisible(false);
			}
		});
		btnAlgorithms.setIcon(new ImageIcon("icons_GUI\\algorithm.png"));
		btnAlgorithms.setBounds(11, 310, 179, 73);
		frame.getContentPane().add(btnAlgorithms);
		
		/**
		 * filter_pannel buttons
		 */

		JButton btnNewButton_3 = new JButton("Filters");
		btnNewButton_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 33));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter_panel.setVisible(true);
				IOpanel.setVisible(false);
				algo_panel.setVisible(false);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("icons_GUI\\filter.png"));
		btnNewButton_3.setBounds(11, 201, 179, 73);
		frame.getContentPane().add(btnNewButton_3);

		Label label = new Label("How would you like to filter your file?");
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		label.setBounds(33, 11, 500, 32);
		filter_panel.add(label);
		/////////////////////////////
		JRadioButton Not = new JRadioButton("Not");
		Not.setMnemonic(KeyEvent.VK_D);
		Not.setVisible(true);
		Not.setFont(new Font("Tahoma", Font.BOLD, 17));
		Not.setBackground(null);
		Not.setBounds(550, 50, 60, 45);
		filter_panel.add(Not);
		Not.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				not=true;
			}
		});
		////////////////////////////
	
		JButton btnSaveFilter = new JButton("Create CSV");
		btnSaveFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSaveFilter.setBounds(175, 281, 129, 59);
		filter_panel.add(btnSaveFilter);
		btnSaveFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_filter.create_Filter(_rec,gate);
				JOptionPane.showMessageDialog(null, "CSV + KML created");
			}
		});

		///another filter panel
		JPanel filter_More = new JPanel();
		filter_More.setBorder(new LineBorder(new Color(204, 51, 153)));
		filter_More.setVisible(false);
		filter_More.setBackground(Color.WHITE);
		filter_More.setBounds(218, 40, 667, 404);
		frame.getContentPane().add(filter_More);
		filter_More.setLayout(null);
		////////////////////////////////
		
		JRadioButton Not1 = new JRadioButton("Not");
		Not1.setMnemonic(KeyEvent.VK_D);
		Not1.setVisible(false);
		Not1.setFont(new Font("Tahoma", Font.BOLD, 17));
		Not1.setBounds(550, 50, 60, 45);
		Not1.setBackground(null);
		filter_More.add(Not1);
		Not1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				not1=true;
			}
		});
		////////////////////////////
		JButton filtermore = new JButton("Add filter");
		filtermore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		filtermore.setBounds(470, 281, 145, 59);
		filter_panel.add(filtermore);
		filtermore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter_More.setVisible(true);
				filter_panel.setVisible(false);
			}
		});
		////////////////////////////
		JButton Load = new JButton("Load filter");
		Load.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Load.setBounds(470, 200, 145, 59);
		filter_panel.add(Load);
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_filter = new filter_Rec();
				_filter.deserializeFromFile("C:\\Users\\a\\git\\OO_Project\\ObjectOriented\\"+filter+".ser");
				JOptionPane.showMessageDialog(null, "Press on save filter");
			}
		});
		//////////////////////////////
		JButton save = new JButton("Save filter to PC");
		save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		save.setBounds(270, 200, 170, 59);
		filter_panel.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					filter=_filter.toString();
					_filter.saveFilterToDisk("C:\\Users\\a\\git\\OO_Project\\ObjectOriented"+"\\"+_filter.toString()+".ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Saved to PC");
			}
		});
		//////////////////////////////
		Label label1 = new Label("Choose logic gate to filter by :");
		label1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		label1.setBounds(33, 11, 500, 32);
		filter_More.add(label1);

		////////buttons//////////
		JRadioButton model2 = new JRadioButton("Model");
		JRadioButton time2 = new JRadioButton("Time");
		JRadioButton Location2 = new JRadioButton("Location");
		JRadioButton and = new JRadioButton("And");
		JRadioButton Or_Filter = new JRadioButton("Or");
		JRadioButton Not_Filter = new JRadioButton("Not");
		Label label2 = new Label("Choose how to filter your scan :");
		//////////////////////////
		and.setMnemonic(KeyEvent.VK_B);
		and.setVisible(true);
		and.setFont(new Font("Tahoma", Font.BOLD, 17));
		and.setBackground(null);
		and.setBounds(208, 72, 98, 59);
		filter_More.add(and);
		and.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				time2.setVisible(true);
				Not1.setVisible(true);
				Location2.setVisible(true);
				model2.setVisible(true);
				label2.setVisible(true);
				Or_Filter.setVisible(false);
				Not_Filter.setVisible(false);
				gate = "And";
			}});

		Or_Filter.setMnemonic(KeyEvent.VK_C);
		Or_Filter.setVisible(true);
		Or_Filter.setFont(new Font("Tahoma", Font.BOLD, 17));
		Or_Filter.setBounds(68, 72, 98, 59);
		Or_Filter.setBackground(null);
		filter_More.add(Or_Filter);
		Or_Filter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				time2.setVisible(true);
				Location2.setVisible(true);
				model2.setVisible(true);
				Not1.setVisible(true);
				label2.setVisible(true);
				and.setVisible(false);
				Not_Filter.setVisible(false);
				gate = "Or";
			}});
		
		//////////////////////////
		label2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		label2.setBounds(33, 150, 500, 32);
		label2.setVisible(false);
		filter_More.add(label2);

		///////functions/////////
		model2.setFont(new Font("Tahoma", Font.BOLD, 17));
		model2.setBounds(208, 200, 98, 59);
		model2.setBackground(null);
		model2.setVisible(false);
		filter_More.add(model2);
		model2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model1 = JOptionPane.showInputDialog(null, "Enter model : ", "Model",JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");	

			}});


		time2.setFont(new Font("Tahoma", Font.BOLD, 17));
		time2.setBounds(68, 200, 98, 59);
		time2.setBackground(null);
		filter_More.add(time2);
		time2.setVisible(false);
		time2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model2.setVisible(false);
				Location2.setVisible(false);
				label2.setVisible(true);
				Or_Filter.setVisible(true);
				Not_Filter.setVisible(true);
				and.setVisible(true);
				start2 = JOptionPane.showInputDialog(null, "Enter start time :\nformat: YY-MM-DD HH:MM:SS (include space) ", "Start Time",JOptionPane.QUESTION_MESSAGE);
				end2 = JOptionPane.showInputDialog(null, "Enter end time :\nformat: YY-MM-DD HH:MM:SS (include space) ", "End Time",JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");
			}});


		Location2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Location2.setBounds(333, 200, 130, 59);
		Location2.setBackground(null);
		filter_More.add(Location2);
		Location2.setVisible(false);
		Location2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model2.setVisible(false);
				time2.setVisible(false);
				label2.setVisible(true);
				Or_Filter.setVisible(true);
				Not_Filter.setVisible(true);
				and.setVisible(true);
				lat = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter lat : ", "Location",JOptionPane.QUESTION_MESSAGE));
				lon = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter lon : ", "Location",JOptionPane.QUESTION_MESSAGE));
				alt = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter alt : ", "Location",JOptionPane.QUESTION_MESSAGE));
				radius = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter radius : ", "Location",JOptionPane.QUESTION_MESSAGE));
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");
			}});

		///////////////////////////////////
		JButton btnsaveFilter2 = new JButton("Save new filter");
		btnsaveFilter2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnsaveFilter2.setBounds(30, 281, 150, 59);
		filter_More.add(btnsaveFilter2);
		btnsaveFilter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!end2.isEmpty() && !start2.isEmpty()){
					_filter.add_Time_Filter(start2, end2 ,not1);
					JOptionPane.showMessageDialog(null, "Data saved");
				}
				if(!model1.isEmpty()){
					_filter.add_Model_Filter(model1, not1);
					JOptionPane.showMessageDialog(null, "Data saved");
				}
				if(alt!=0 || lat !=0 || lon !=0){
					_filter.add_Location_Filter(alt, lat, lon, radius, not1);
					JOptionPane.showMessageDialog(null, "Data saved");
				}
			}
		});
		/////////////////////////////////
		JButton backToFilter = new JButton("Back");
		backToFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backToFilter.setBounds(500, 320, 80, 40);
		filter_More.add(backToFilter);
		backToFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter_More.setVisible(false);
				filter_panel.setVisible(true);
				time2.setVisible(false);
				Not1.setVisible(false);
				Location2.setVisible(false);
				model2.setVisible(false);
				label2.setVisible(false);
				Or_Filter.setVisible(true);
				Not_Filter.setVisible(true);
				and.setVisible(true);
			}
		});
		///////////////////////////////
		JButton btnDeleteFilter = new JButton("Delete Filter");
		btnDeleteFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteFilter.setBounds(320, 281, 129, 59);
		filter_panel.add(btnDeleteFilter);
		btnDeleteFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_filter = new filter_Rec();
				File file =new File("filteredFile.csv");
				file.delete();
				File file2 = new File("filteredFile.kml");
				file2.delete();
				 start="";start2="";
				 end="";end2="";
				 model="";model1="";
				 alt=0;lat=0;lon=0;radius=0;
				 _filter = new filter_Rec();
				JOptionPane.showMessageDialog(null, "Your filtered file was deleted!\nYou can load the filter or create new");
				
			}
		});
		///////////////////////////////
		JButton btnsaveFilter = new JButton("Save Filter");
		btnsaveFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnsaveFilter.setBounds(30, 281, 129, 59);
		filter_panel.add(btnsaveFilter);
		btnsaveFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!end.isEmpty() && !start.isEmpty()){
					_filter = new filter_Rec();
					_filter.create_Time_Filter(start, end,not);
					JOptionPane.showMessageDialog(null, "Data saved");
					not=false;
				}
				if(!model.isEmpty()){
					_filter = new filter_Rec();
					_filter.create_Model_Filter(model, not);;
					JOptionPane.showMessageDialog(null, "Data saved");
					not=false;
				}
				if(alt!=0 || lat !=0 || lon !=0){
					_filter = new filter_Rec();
					_filter.create_Location_Filter(alt, lat, lon, radius, not);
					JOptionPane.showMessageDialog(null, "Data saved");
					not=false;
				}
			}
		});
		/// TIME FILTER ///
		JRadioButton rdbtnTime = new JRadioButton("Time");
		rdbtnTime.setFont(new Font("Tahoma", Font.BOLD, 25));
		rdbtnTime.setBackground(null);
		rdbtnTime.setBounds(68, 72, 98, 59);
		filter_panel.add(rdbtnTime);
		rdbtnTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				start = JOptionPane.showInputDialog(null, "Enter start time :\nformat: YY-MM-DD HH:MM:SS (include space) ", "Start Time",JOptionPane.QUESTION_MESSAGE);
				end = JOptionPane.showInputDialog(null, "Enter end time :\nformat: YY-MM-DD HH:MM:SS (include space) ", "End Time",JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");
				JOptionPane.showMessageDialog(null, "Press on 'Save filter'");
			}});

		/// MODEL FILTER ///
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Model");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		rdbtnNewRadioButton.setBackground(null);
		rdbtnNewRadioButton.setBounds(208, 72, 120, 59);
		filter_panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model = JOptionPane.showInputDialog(null, "Enter model : ", "Model",JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");
				JOptionPane.showMessageDialog(null, "Press on 'Save filter'");
			}});

		///LOCATION FILTER ///
		JRadioButton rdbtnLocation = new JRadioButton("Location");
		rdbtnLocation.setFont(new Font("Tahoma", Font.BOLD, 25));
		rdbtnLocation.setBackground(null);
		rdbtnLocation.setBounds(333, 72, 160, 59);
		filter_panel.add(rdbtnLocation);
		rdbtnLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lat = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter lat : ", "Location",JOptionPane.QUESTION_MESSAGE));
				lon = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter lon : ", "Location",JOptionPane.QUESTION_MESSAGE));
				alt = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter alt : ", "Location",JOptionPane.QUESTION_MESSAGE));
				radius = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter radius : ", "Location",JOptionPane.QUESTION_MESSAGE));
				JOptionPane.showMessageDialog(null, "Data saved succsesfuly");
				JOptionPane.showMessageDialog(null, "Press on 'Save filter'");
			}});


		/// algo panel buttons
		//algo1
		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.setBounds(76, 52, 199, 111);
		btnAlgorithm.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		algo_panel.setLayout(null);
		algo_panel.add(btnAlgorithm);
		btnAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo1name = JOptionPane.showInputDialog(null, "Enter comb CSV file name\n(from algo2 folder) : ", "Algo1",JOptionPane.QUESTION_MESSAGE);
				Algo_1 a = new Algo_1();
				a.readFile(algo1name+".csv");
				a.locate_Mac();
				a.toCsv("Algo1.csv");
				JOptionPane.showMessageDialog(null, "CSV for algo1 was created");
			}
		});

		///algo2
		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.setBounds(400, 230, 199, 111);
		btnAlgorithm_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		algo_panel.add(btnAlgorithm_1);
		btnAlgorithm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo2name = JOptionPane.showInputDialog(null, "Enter CSV file name contains 1 no_gps line to read : ", "Algo2",JOptionPane.QUESTION_MESSAGE);
				comb = JOptionPane.showInputDialog(null, "Enter comb CSV file name\n(from algo2 folder) : ", "Algo2",JOptionPane.QUESTION_MESSAGE);
				System.out.println(algo2name);
				algo2 a = new algo2();
				a.readFile(algo2name+".csv");
				a.readFile2(comb+".csv");
				a.search_Mac();
				a.toCsv("complete_File_Algo_2.csv");
				JOptionPane.showMessageDialog(null, "CSV for algo2 was created");
			}
		});

		JButton btnNewButton_2 = new JButton(" I/O");
		btnNewButton_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 33));
		btnNewButton_2.setIcon(new ImageIcon("icons_GUI\\output.png"));
		btnNewButton_2.setBounds(11, 92, 179, 73);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IOpanel.setVisible(true);
				filter_panel.setVisible(false);
				algo_panel.setVisible(false);
			}
		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Path path = Paths.get("C:/Users/a/git/OO_Project");
					WatchService watchService;
					watchService = path.getFileSystem().newWatchService();

					path.register(watchService,
							StandardWatchEventKinds.ENTRY_CREATE,
							StandardWatchEventKinds.ENTRY_MODIFY,
							StandardWatchEventKinds.ENTRY_DELETE);

					while(true) {
						WatchKey watchKey = null;
						try {
							watchKey = watchService.take();

						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for (WatchEvent<?> event : watchKey.pollEvents()) {
							if((event.kind().name().equals("ENTRY_CREATE"))||
								(event.kind().name().equals("ENTRY_DELETE"))||
								(event.kind().name().equals("ENTRY_MODIFY"))) {
								JOptionPane.showMessageDialog(frame.getContentPane(),"Records Was Changed !!!","change",JOptionPane.WARNING_MESSAGE);
							//check the window
								_rec = new Records();
								_rec.parseFile("C:/Users/a/git/OO_Project");
						_rec.toCsv(fileName+"new.csv");
							}

						}
						
						if(!watchKey.reset()) {
							watchKey.cancel();
							watchService.close();
						}
					}
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}

		}).start();
	}   
}