package matala_1;

import java.util.ArrayList;
import java.util.List;
import matala_1.WriteCsv;

/**
 * This class creates a new parse CSV file base on wifiNetworks that was captured on specific time
 *  
 * @author Bar, Noy, Doriya
 *
 */
public class ParsingFiles extends ReadFiles{

	public static  List<LineFile> parse_File(List<String[]> file){
		List<LineFile> line = new ArrayList<LineFile>();
		String [] id = file.get(0);
		Model ID = new Model(id[2]);
		int countNet =0;
		for (int i = 2; i < file.size(); i+=countNet) {
			String[]s = file.get(i);
			Time time = new Time(s[3]);
			List<Network> Wifi = new ArrayList<Network>();
			double lat = Double.parseDouble(s[6]);
			double lon = Double.parseDouble(s[7]);
			double alt = Double.parseDouble(s[8]);
			Coordinate coor = new Coordinate(lon, lat, alt);
			Location l = new Location(coor);
			countNet =0;
			for (int j = 2; j < file.size(); j++) {
				String[] lines = file.get(j);
				Time t = new Time(lines[3]);
				if (t.equal_Time(time)){
					Network wifi = new Network(lines[1],lines[0],lines[5],lines[4]);
					Wifi.add(wifi);
					countNet++;	
				}
			}
			Wifi.sort(null);
			List<Network> Wifi2 = new ArrayList<Network>();
			for (int c = 0; c <Wifi.size()&&c<10; c++){
				Wifi2.add(Wifi.get(c));
			}
			line.add(new LineFile(time,ID,l,countNet,Wifi2));
		}
		return line;
	}
	
	public static List<LineFile> merge_File(String[] files){
		List<LineFile> mergeFile = new ArrayList<LineFile>();
		List<LineFile> file = new ArrayList<LineFile>();
		for (int i = 0; i < files.length; i++) {
			file = parse_File(readFile(files[i]));
			mergeFile.addAll(file);
		}
		return mergeFile;
		
	}

	public static void main(String[] args) {
		Folder f  = new Folder("C:/Users/a/workspace/ObjectOriented") ;
		String []s = f.csv_Files("C:/Users/a/workspace/ObjectOriented");
		List<LineFile> fin = new ArrayList<LineFile>();
		fin = merge_File(s);
		WriteCsv.writeFile(fin, "fin.csv");
		
	}
	
}
