package matala_1;

import java.io.BufferedWriter;
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
	private List<Algo1_linefile> _fileList;
	final int max_Signals = 4 ;
	private ArrayList<Double> _wLat;
	private ArrayList<Double> _wLon;
	private ArrayList<Double> _wAlt;
	private ArrayList<Double> _wWeigth;
	private double wLon,wLat,wAlt;

	public Algo_1(Records _rec){
		_rec = new Records();
	}
	/**
	 * This functions search for the MAC in the Records list, takes 4 MAC with strongest signal 
	 * and calculate the wLat,wLon,wAlt according to the demands
	 * @param rec Record<LineFile> list
	 * @param mac String MAC address
	 */
	public void locate_Mac(Records rec){
		List<LineFile> _line = rec.get_rec();// כל הרשימה
		_fileList = new ArrayList<Algo1_linefile>();
		for(LineFile l : _line){
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
					line = search(mac, rec);
				
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

	public List<Algo1_line> search(String mac, Records r){
		List<Algo1_line> line = new ArrayList<Algo1_line>();
		List<LineFile> _line = r.get_rec();
		for(LineFile _list : _line){
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
	public static void main(String[] args) {
		Records r = new Records();
		r.parseFile("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		r.toCsv("Merge_File.csv");
		Algo_1 a = new Algo_1(r);
		a.locate_Mac(r);
		a.toCsv2("algo1.csv");
	}
}
