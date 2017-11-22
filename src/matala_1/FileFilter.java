package matala_1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the function for the filter
 * 
 * @author Bar, Noy, Doriya
 *
 */
public class FileFilter{
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
}
