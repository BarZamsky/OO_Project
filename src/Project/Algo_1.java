package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents functions that read merge CSV file and calculate w-center for every mac address in it
 *@author Doriya, Noy, Bar
 */
public class Algo_1 implements Functions{
	private List<LineFile> _file;
	private List<Algo1_linefile> _fileList;
	private ArrayList<Double> _wLat;
	private ArrayList<Double> _wLon;
	private ArrayList<Double> _wAlt;
	private ArrayList<Double> _wWeigth;
	private double wLon,wLat,wAlt;
	public static int max_Signal=4;
	
	public Algo_1(){
		_file = new ArrayList<LineFile>();
	}
	/**
	 * This function go over the list and for every mac address in it 
	 * calculate the wLat,wLon,wAlt according to the demands
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
					for(int i=0;i<max_Signal && i<line.size();i++){
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
		for(int i=0; i<max_Signal && i<_wAlt.size() && i<_wLon.size() && i<_wLat.size() && i< _wWeigth.size();i++){
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
	 * This function reads the merged csv input
	 * @param fileName merged file name
	 */
	@Override
	public void readFile(String fileName){
		_file = new ArrayList<LineFile>();
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
				_file.add(new LineFile(time,str[1],point,Double.parseDouble(str[4]),Integer.parseInt(str[5]), net));
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	@Override
	public void toCsv(String fileName) {
		try{
			FileWriter fw = new FileWriter(fileName);
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
	public static void main(String[] args) {
		Algo_1 a = new Algo_1();
		a.readFile("comb_BM3.csv");
		a.locate_Mac();
		a.toCsv("algo1.csv");
	}

}
