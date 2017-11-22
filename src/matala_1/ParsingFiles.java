package matala_1;

import java.util.ArrayList;
import java.util.List;
import matala_1.WriteCsv;

/**
 * This class creates a new parse CSV file base on wifiNetworks that was captured on specific time
 * In the main you can enter the condition for filtering the list
 * @author Bar, Noy, Doriya
 *
 */
public class ParsingFiles extends ReadFiles{

	public static  List<LineFile> parse_File(List<String[]> file){
		List<LineFile> line = new ArrayList<LineFile>();
		String [] id = file.get(0);
		Model ID = new Model(id[2].replace("model=", ""));
		int countNet =0;
		for (int i = 2; i < file.size(); i+=countNet) {
			String[]s = file.get(i);
			Time time =new Time();
			time = time.set_Date(s[3]);
			List<Network> Wifi = new ArrayList<Network>();
			double lat = Double.parseDouble(s[6]);
			double lon = Double.parseDouble(s[7]);
			double alt = Double.parseDouble(s[8]);
			Coordinate coor = new Coordinate(lon, lat, alt);
			Location l = new Location(coor);
			countNet =0;
			for (int j = 2; j < file.size(); j++) {
				String[] lines = file.get(j);
				Time time2 = new Time();
				time2=time2.set_Date(lines[3]);
				if (time2.is_Equal(time)){
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
	//	Folder f  = new Folder("C:\\Users\\a\\git\\OO_Project\\ObjectOriented") ;
		String []s = Folder.csv_Files("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		System.out.println(s);
		List<LineFile> fin = new ArrayList<LineFile>();
		fin = merge_File(s);
		WriteCsv.writeFile(fin, "fin.csv");
		//filter c3 = list->list.getTime().getMinute()==22;
		//filter c2 = list->list.getModel().toString().equals("SM-G950F");
		filter c1 = list->list.getLocation().getPoints().getAlt()>=650;
		List<LineFile> filteredStrings = FileFilter.filter(fin,c1);
		WriteCsv.writeFile(filteredStrings,"filterList.csv");
	}
}
