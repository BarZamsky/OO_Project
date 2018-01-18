package GUI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class ChooseFolder {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static String run(String title) {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle(title);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = jfc.showDialog(null,"Choose");
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				System.out.println(jfc.getCurrentDirectory().getPath());

				return jfc.getCurrentDirectory().getPath();
			}
		}
		return null;

	}
}
