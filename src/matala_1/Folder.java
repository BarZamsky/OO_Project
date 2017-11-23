package matala_1;

import java.io.File;
/**
 * This class represent functions in order to read folder
 * @author Bar,Noy,Doriya
 *
 */
public class Folder extends File {

private static final long serialVersionUID = 1L;

	public Folder(String Path) {
		super(Path);
	}



/**
 * This functions checks if the folder exist
 * @param path the folder location
 * @return true if exist
 */
	public static boolean is_Exist(String path){
		File file = new File(path);
		if(file.isDirectory()){
			return true;
		}
		return false;
	}

	/**
	 * This function insert only CSV files from the given folder into array
	 * @param path location of the folder
	 * @return array of CSV files in the folder
	 */
	public static String[] csv_Files(String path){
		File file = new File(path);
		int counter=0,index=0;
		String[] files = file.list();
		for (int i = 0; i < files.length; i++) {
			if(files[i].endsWith(".csv")){
				counter++;
			}
		}
		String[]csvFiles = new String[counter];
		for (int i = 0; i < files.length; i++) {
			if(files[i].endsWith(".csv")){
				csvFiles[index++]=files[i];
			}
		}
		return csvFiles;
	}
}
