package matala_1;

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents functions to calculate w-center by MAC address
 * @author Doriya , Noy, Bar
 *
 */
public class Algo_1{
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
	public void locate_Mac(Records rec, String mac){
		_wLat = new ArrayList<Double>();
		_wLon = new ArrayList<Double>();
		_wAlt = new ArrayList<Double>();
		_wWeigth = new ArrayList<Double>();
		List<LineFile> _line = rec.get_rec();// כל הרשימה
		List<Algo1_line> line = new ArrayList<Algo1_line>();
		for(LineFile l : _line){
			List<Network> wifi = l.getNetwork();
			for(Network n : wifi){
				if(n.getMac().equals(mac)){
					line.add(new Algo1_line(n.getSignal(),l.getAlt(),l.getLocation()));			
				}
			}
		}

		line.sort(null);
		for(int i=0;i<max_Signals;i++){
			double lat = line.get(i).getLocation().getLat();
			double lon = line.get(i).getLocation().getLon();
			double alt = line.get(i).getAlt();
			double weight = 1/(Math.pow(line.get(i).getSignal(), 2));
			_wLat.add(lat*weight);
			_wLon.add(lon*weight);
			_wAlt.add(alt*weight);
			_wWeigth.add(weight);
		}
	}
/**
 * This function calculate the final w-sum and create new location
 */
	public void calc_Wsum(){
		double sumAlt=0,sumLon=0,sumLat=0,sumW=0;
		for(int i=0;i<max_Signals;i++){
			sumAlt+=_wAlt.get(i);
			sumLon+=_wLon.get(i);
			sumLat+=_wLat.get(i);
			sumW+=_wWeigth.get(i);
		}
		wLon=sumLon/sumW;
	    wLat=sumLat/sumW;
	    wAlt=sumAlt/sumW;
	}
	
	public Point_2D getLocation(){
		return (new Point_2D(wLon, wLat));
	}
	public double getAlt(){
		return wAlt;
	}
	
	public static void main(String[] args) {
		Records r = new Records();
		r.parseFile("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		r.toCsv("Merge_File.csv");
		Algo_1 a = new Algo_1(r);
		a.locate_Mac(r, "0a:8d:db:6e:71:6d");
		a.calc_Wsum();
		System.out.println(a.getLocation().toString());
		System.out.println(a.getAlt());
	}
}
