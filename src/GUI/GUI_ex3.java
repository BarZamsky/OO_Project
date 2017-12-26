package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import Project.Records;
import Project.Point_2D;
import Project.LineFile;
import Project.Network;
import Project.Filter_Your_File;
import Project.Time;

public class GUI_ex3 extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
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
			public void actionPerformed(ActionEvent e) {
			}
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
			public void actionPerformed(ActionEvent e) {
			}
		});
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
	}
}
