package matala_1;

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents the main class for algo2
 * @author Bar, Noy, Doriya
 *
 */
public class Algo_2 {
	final int NO_SIGNAL = -120;
	private Algo2_line _mac1,_mac2,_mac3;
	private ArrayList<Algo_2> comb;
	private double _pi;
	private double _wLat,_wLon,_wAlt;
	private double w_alt, w_lon, w_lat;

	public Algo_2(Records _rec){
		_rec = new Records();
	}
	public Algo_2(LineFile linefile, Algo2_line _mac1, Algo2_line _mac2, Algo2_line _mac3) {
		this._mac1 = _mac1;
		this._mac2 = _mac2;
		this._mac3 = _mac3;
		_pi = _mac1.get_weight()*_mac2.get_weight()*_mac3.get_weight();
		_wLat = linefile.getLocation().getLat()*_pi;
		_wLon = linefile.getLocation().getLon()*_pi;
		_wAlt = linefile.getAlt()*_pi;
	}
/**
 * This functions receives 3 MAC address and 3 signals and apply on them the Algo2
 * @param _rec Record of wifi lines
 * @param mac1
 * @param signal1
 * @param mac2
 * @param signal2
 * @param mac3
 * @param signal3
 */
	public void find_Mac(Records _rec, String mac1,int signal1,String mac2,int signal2, String mac3,int signal3){
		List<LineFile> _line = _rec.get_rec();
		List<Algo2_line> algo1 = new ArrayList<Algo2_line>();
		List<Algo2_line> algo2 = new ArrayList<Algo2_line>();
		List<Algo2_line> algo3 = new ArrayList<Algo2_line>();
		comb = new ArrayList<Algo_2>();
		
		for(LineFile line : _line){ 
			List<Network> _wifi = line.getNetwork();
			for(Network wifi : _wifi){
				Algo2_line a,b,c;
				if(wifi.getMac().equals(mac1)){
					 a = new Algo2_line(signal1, wifi.getSignal());
					algo1.add(a);
				}
				else{
					a =new Algo2_line(signal1,NO_SIGNAL);
					algo1.add(a);
				}
				if(wifi.getMac().equals(mac2)){
					b = new Algo2_line(signal2, wifi.getSignal());
					algo2.add(b);
				}
				else{
					b =new Algo2_line(signal2,NO_SIGNAL);
					algo2.add(b);
				}
				if(wifi.getMac().equals(mac3)){
					c =new Algo2_line(signal3, wifi.getSignal());
					algo3.add(c);
				}
				else{
					c =new Algo2_line(signal3,NO_SIGNAL);
					algo3.add(c);
				}
				algo1.sort(null);algo2.sort(null);algo3.sort(null);
				comb.add(new Algo_2(line, a, b, c));
			}	
		}
}
	/**
	 * This function calculates the w-sum of those 3 MAC address
	 */
	public void calc_Weight(){
		double sum_wAlt=0,sum_wLon=0,sum_wLat=0,sum_Weight=0;
		for (int i=0;i<3; i++){
			sum_wAlt+=comb.get(i)._wAlt;
			sum_wLon+=comb.get(i)._wLon;
			sum_wLat+=comb.get(i)._wLat;
			sum_Weight+=comb.get(i)._pi;
		}
		w_alt=sum_wAlt/sum_Weight;
		w_lon=sum_wLon/sum_Weight;
		w_lat=sum_wLat/sum_Weight;
	}
	public Point_2D getLocation(){
		return (new Point_2D(w_lon, w_lat));
	}
	public double getAlt(){
		return w_alt;
	}
	
public static void main(String[] args) {
	Records r = new Records();
	r.parseFile("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
	r.toCsv("Merge_File.csv");
	Algo_2 a = new Algo_2(r);
	a.find_Mac(r, "c4:12:f5:fd:d1:94", -50, "e8:fc:af:9d:69:be", -80, "7c:b7:33:2e:76:73", -30);
	a.calc_Weight();
	System.out.println(a.getLocation().toString()+","+a.getAlt());
	
}
}
