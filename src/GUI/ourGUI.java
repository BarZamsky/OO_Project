package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;

public class ourGUI {

	private JFrame frmOop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ourGUI window = new ourGUI();
					window.frmOop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ourGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOop = new JFrame();
		frmOop.setTitle("OOP \u2665");
		frmOop.setBounds(100, 100, 668, 418);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOop.getContentPane().setLayout(null);
		
		JButton btnNameOfScv = new JButton("Name of CSV file");
		btnNameOfScv.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/file.png")));
		btnNameOfScv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfScv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNameOfScv.setBounds(42, 138, 253, 37);
		frmOop.getContentPane().add(btnNameOfScv);
		
		JButton btnNameOfFolder = new JButton("  Name of folder");
		btnNameOfFolder.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/folder.png")));
		btnNameOfFolder.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfFolder.setBounds(42, 77, 253, 37);
		frmOop.getContentPane().add(btnNameOfFolder);
		
		JButton btnInformation = new JButton("  Information");
		btnInformation.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/info.png")));
		btnInformation.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInformation.setBounds(42, 260, 253, 37);
		frmOop.getContentPane().add(btnInformation);
		
		JButton btnDelete = new JButton("  Delete");
		btnDelete.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/delete.png")));
		btnDelete.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(42, 199, 253, 37);
		frmOop.getContentPane().add(btnDelete);
		
		JButton btnSaveAsKml = new JButton("Save as KML file");
		btnSaveAsKml.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/kml-file-format-interface_24.png")));
		btnSaveAsKml.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveAsKml.setBounds(365, 138, 253, 37);
		frmOop.getContentPane().add(btnSaveAsKml);
		
		JButton btnSaveCombCsv = new JButton("Save as comb CSV");
		btnSaveCombCsv.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/csv.png")));
		btnSaveCombCsv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveCombCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});   
		
		btnSaveCombCsv.setBounds(365, 77, 253, 37);
		frmOop.getContentPane().add(btnSaveCombCsv);
		 
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Input / Output:");
		lblNewJgoodiesTitle.setFont(new Font("Gisha", Font.BOLD, 26));
		lblNewJgoodiesTitle.setBounds(222, 24, 196, 29);
		frmOop.getContentPane().add(lblNewJgoodiesTitle);
		 
		JButton btnNewButton = new JButton("  Filters");
		btnNewButton.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/filter.png")));
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton.setBounds(365, 189, 253, 37);
		frmOop.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Algorithms");
		btnNewButton_1.setIcon(new ImageIcon(ourGUI.class.getResource("/GUI_resource/algorithm.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton_1.setBounds(365, 258, 253, 37);
		frmOop.getContentPane().add(btnNewButton_1);
	}
}
