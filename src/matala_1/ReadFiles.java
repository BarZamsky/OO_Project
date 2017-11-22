package matala_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class read a csv file into ArrayList 
 * @author Bar,Noy,Doriya
 *
 */
public class ReadFiles {
	//reading the initial file
	public static List<String[]> readFile(String fileName){
		List<String[]> file = new ArrayList<String[]>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line="";
			file.add(br.readLine().split(","));
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				if(str[10].equals("WIFI")){
					file.add(str);
				}
		}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return file;
	}
	//reading the merge file
	static List<String[]> readFile2(String fileName){
		List<String[]> file = new ArrayList<>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				file.add(line.split(","));
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
		return file;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
