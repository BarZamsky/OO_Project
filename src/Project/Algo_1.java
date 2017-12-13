package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents functions to calculate w-center by MAC address
 * @author Doriya , Noy, Bar
 *
 */
public class Algo_1{
	private List<LineFile> _file;
	private List<Algo1_linefile> _fileList;
	final int max_Signals = 4 ;
	private ArrayList<Double> _wLat;
	private ArrayList<Double> _wLon;
	private ArrayList<Double> _wAlt;
	private ArrayList<Double> _wWeigth;
	private double wLon,wLat,wAlt;

	public Algo_1(){
		_file = new ArrayList<LineFile>();
	}
	/**
	 * This functions search for the MAC in the Records list, takes 4 MAC with strongest signal 
	 * and calculate the wLat,wLon,wAlt according to the demands
	 */
	public void locate_Mac(){
		_fileList = new ArrayList<Algo1_linefile>();
		for(LineFile l : _file){
			List<Algo1_line> line = new ArrayList<Algo1_line>();
			
			_wLat = new ArrayList<Double>();
			_wLon = new ArrayList<Double>();
			_wAlt = new ArrayList<Double>();
			_wWeigth = new ArrayList<Double>();
			List<Network> wifi = l.getNetwork();
			for(Network n : wifi){
				List<Network> net = new ArrayList<Network>();
				if(n.isTaken()==false){
				String mac = n.getMac();
					net.add(n);
					line = search(mac, _file);
				
			line.sort(null);
			for(int i=0;i<max_Signals && i<line.size();i++){
				double lat = line.get(i).getLocation().getLat();
				double lon = line.get(i).getLocation().getLon();
				double alt = line.get(i).getAlt();
				double weight = 1/(Math.pow(line.get(i).getSignal(), 2));
				_wLat.add(lat*weight);
				_wLon.add(lon*weight);
				_wAlt.add(alt*weight);
				_wWeigth.add(weight);
			}
			
			calc_Wsum();
			_fileList.add(new Algo1_linefile(l.getTime(), new Point_2D(wLon, wLat), wAlt, net.get(0)));
			}
			}
			}
		for(Algo1_linefile a: _fileList){
			System.out.println(a.toString());
		}
	}
/**
 * This function search in the list for same mac address as given 
 * @param mac the mac to search in the list
 * @param _file LineFile list
 * @return new Algo1_line list
 */
	public List<Algo1_line> search(String mac, List<LineFile> _file){
		List<Algo1_line> line = new ArrayList<Algo1_line>();;
		for(LineFile _list : _file){
			List<Network> net = _list.getNetwork();
			for(Network n: net){
				if (n.getMac().equals(mac)){
					line.add(new Algo1_line(n.getSignal(),_list.getAlt(),_list.getLocation()));	
					n.setTaken(true);
				}
			}
		}
		return line;
	}
	/**
	 * This function calculate the final w-sum and create new location
	 */
	public void calc_Wsum(){
		double sumAlt=0,sumLon=0,sumLat=0,sumW=0;
		for(int i=0;i<max_Signals && i<_wAlt.size() && i<_wLon.size() && i<_wLat.size() && i< _wWeigth.size();i++){
			sumAlt+=_wAlt.get(i);
			sumLon+=_wLon.get(i);
			sumLat+=_wLat.get(i);
			sumW+=_wWeigth.get(i);
		}
		wLon=sumLon/sumW;
		wLat=sumLat/sumW;
		wAlt=sumAlt/sumW;
	}
	/**
	 * This function write the new csv file
	 * @param output output csv file name
	 */
	public void toCsv2(String output){
		try{
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Algo1_linefile l : _fileList){
				bw.write(l.toString().replace("[", "").replace("]", ""));
				bw.write("\n");
			}
			bw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
	}
	/**
	 * This function reads the merged csv input
	 * @param fileName merged file name
	 */
	public void readFile(String fileName){
		List<LineFile> files = new ArrayList<LineFile>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line="";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				List<Network> net = new ArrayList<Network>();
				Point_2D point = new Point_2D(Double.parseDouble(str[2]),Double.parseDouble(str[3]));
				Time time = new Time();
				time = time.set_Date2(str[0]);
				for(int i=6;i<str.length;i+=4){
					Network n = new Network(str[i], str[i+1], Integer.parseInt(str[i+2]), str[i+3]);
					net.add(n);
				}
				files.add(new LineFile(time,str[1],point,Double.parseDouble(str[4]),Integer.parseInt(str[5]), net));
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	public static void main(String[] args) {
		Algo_1 a = new Algo_1();
		a.readFile("Merge_File.csv");
		a.locate_Mac();
		a.toCsv2("algo1.csv");
	}
}
