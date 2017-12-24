package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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
		btnNameOfScv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfScv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNameOfScv.setBounds(42, 138, 217, 37);
		frmOop.getContentPane().add(btnNameOfScv);
		
		JButton btnNameOfFolder = new JButton("Name of folder");
		btnNameOfFolder.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNameOfFolder.setBounds(42, 77, 217, 37);
		frmOop.getContentPane().add(btnNameOfFolder);
		
		JButton btnInformation = new JButton("Information");
		btnInformation.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInformation.setBounds(42, 260, 217, 37);
		frmOop.getContentPane().add(btnInformation);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(42, 199, 217, 37);
		frmOop.getContentPane().add(btnDelete);
		
		JButton btnSaveAsKml = new JButton("Save as KML file");
		btnSaveAsKml.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveAsKml.setBounds(382, 138, 217, 37);
		frmOop.getContentPane().add(btnSaveAsKml);
		
		JButton btnSaveCombCsv = new JButton("Save as comb CSV");
		btnSaveCombCsv.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnSaveCombCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveCombCsv.setBounds(382, 75, 217, 37);
		frmOop.getContentPane().add(btnSaveCombCsv);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Input / Output:");
		lblNewJgoodiesTitle.setFont(new Font("Gisha", Font.BOLD, 26));
		lblNewJgoodiesTitle.setBounds(222, 24, 196, 29);
		frmOop.getContentPane().add(lblNewJgoodiesTitle);
		
		JButton btnNewButton = new JButton("Filters");
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton.setBounds(382, 197, 217, 37);
		frmOop.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Algorithms");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 22));
		btnNewButton_1.setBounds(382, 258, 217, 37);
		frmOop.getContentPane().add(btnNewButton_1);
	}
}
