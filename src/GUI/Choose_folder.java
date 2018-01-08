package GUI;
	import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.*;
	import java.awt.*;
/**
 * This class represent method to select folder from your PC	
 * @author this code is taken from StackOverflow
 *
 */
public class Choose_folder extends JPanel implements ActionListener {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton go;
	   
	   JFileChooser chooser;
	   
	  public Choose_folder() {
	    go = new JButton("Open path : ");
	    go.addActionListener(this);
	    add(go);
	   }
   
	  public void actionPerformed(ActionEvent e) {
	    chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Select folder:");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    //    
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    	chooser.getApproveButtonText();
	    	go.setVisible(false);
	      }
	    else {
	    JOptionPane.showMessageDialog(null, "No selection");
	    }
	  }
	   
	  public Dimension getPreferredSize(){
	    return new Dimension(200, 200);
	    }
	}
