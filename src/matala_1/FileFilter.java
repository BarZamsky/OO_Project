package matala_1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class reads the merged csv file of WifiNetworks and filtering the file based on ID,TIME or MODEL
 * 
 * @author Bar, Noy, Doriya
 *
 */
public class FileFilter extends ReadFiles {
	/**
	 * This function filtering the csv file based on the condition inserted
	 * @param strings - merged list of all csv files 
	 * @param condition - 
	 * @return ArrayList of the networks after filtering
	 */
	public static List<LineFile> filter(List<LineFile> file, filter condition){
		List<LineFile> output = new ArrayList<>();
		for (LineFile lineFile : file) {
			if(condition.test(lineFile)){
				output.add(lineFile);
			}
		} 
			return output;
	}

	
	public static void main(String[] args) {
		Folder f  = new Folder("C:/Users/a/workspace/ObjectOriented") ;
		String []s = f.csv_Files("C:/Users/a/workspace/ObjectOriented");
		List<LineFile> fin = new ArrayList<LineFile>();
		fin = ParsingFiles.merge_File(s);
		filter c1 = s->s.getLocation().getPoints().getAlt()>=650;
		List<LineFile> filteredStrings = filter(fin,c1);
		WriteCsv.writeFile(filteredStrings,"filterList.csv");
	}
}
