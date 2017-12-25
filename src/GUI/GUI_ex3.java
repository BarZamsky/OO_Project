package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI_ex3 {

	private JFrame frame;

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
		frame.setBounds(100, 100, 668, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 ImageIcon algo = new ImageIcon("algorithm.png");
		 ImageIcon csv = new ImageIcon("csv.png");
		 ImageIcon delete = new ImageIcon("delete.png");
		 ImageIcon file = new ImageIcon("file.png");
		 ImageIcon filter = new ImageIcon("filter.png");
		 ImageIcon folder = new ImageIcon("folder.png");
		 ImageIcon kml = new ImageIcon("kml.png");
		 ImageIcon info = new ImageIcon("info.png");
		 
		JButton btnNameOfScv = new JButton("Name of CSV file",file);
		btnNameOfScv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfScv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNameOfScv.setBounds(42, 138, 253, 37);
		frame.getContentPane().add(btnNameOfScv);
		
		JButton btnNameOfFolder = new JButton("Name of folder",folder);
		btnNameOfFolder.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfFolder.setBounds(42, 77, 253, 37);
		frame.getContentPane().add(btnNameOfFolder);
		
		JButton btnInformation = new JButton("  Information",info);
		btnInformation.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInformation.setBounds(42, 260, 253, 37);
		frame.getContentPane().add(btnInformation);
		
		JButton btnDelete = new JButton("  Delete",delete);
		btnDelete.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(42, 199, 253, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSaveAsKml = new JButton("Save as KML file",kml);
		btnSaveAsKml.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveAsKml.setBounds(365, 138, 253, 37);
		frame.getContentPane().add(btnSaveAsKml);
		
		JButton btnSaveCombCsv = new JButton("Save as comb CSV",csv);
		btnSaveCombCsv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveCombCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});   
		
		btnSaveCombCsv.setBounds(365, 77, 253, 37);
		frame.getContentPane().add(btnSaveCombCsv);
		 
		JLabel lblNewJgoodiesTitle = new JLabel("OOP_Ex3");
		lblNewJgoodiesTitle.setFont(new Font("Gisha", Font.BOLD, 26));
		lblNewJgoodiesTitle.setBounds(260, 24, 200, 29);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		 
		JButton btnNewButton = new JButton("  Filters",filter);
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton.setBounds(365, 199, 253, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Algorithms",algo);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton_1.setBounds(365, 258, 253, 37);
		frame.getContentPane().add(btnNewButton_1);
	}
}
