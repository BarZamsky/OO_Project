package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class represents the main class for algo2
 * @author Bar, Noy, Doriya
 */
public class Algo_2 {
	private Algo2_line _mac1;
	private Algo2_line _mac2;
	private Algo2_line _mac3;
	//private List<LineFile> _file;
	private ArrayList<Algo2_line> algo2;
	private double _pi;
	private double _wLat,_wLon,_wAlt;
	private double w_alt, w_lon, w_lat;

	public Algo_2(Records Data, Records Input){
		Data = new Records();
		Input = new Records();
	}
	public Algo_2(Algo2_line _mac1, Algo2_line _mac2, Algo2_line _mac3) { //we need to get n 
		this._mac1 = _mac1;
		this._mac2 = _mac2;
		this._mac3 = _mac3;
	}
	/**
	 * מקבלת INPUT, לוקחים כל שורה שם ומשווים לDATA
	 * ואז לוקחים את הPI 
	 * ממיינים לפי 3 PI
	 *  ומפעילים אלגו2
	 * This functions receives Input.CSV  and apply on them the Algo2
	 * @param Data Record of wifi lines
	 * @param Input Record of wifi lines without GPS
	 */
	public void find_Mac(Records Data, Records Input, int n){
		List<LineFile> _line = Data.get_rec();
		HashMap<String,List<Algo2_line>> hm=new HashMap<String,List<Algo2_line>>();  

		comb = new ArrayList<Algo_2>();
		List<Algo2_line> Input_line = new ArrayList<Algo2_line>();
		for (Algo2_line line : Input_line) {//for input
			List<Network> wifiInput = line.getNetwork(); //לבדוק את  getNetwork
			wifiInput.sort(null);

			/* 		
		_pi = _mac1.get_weight()*_mac2.get_weight()*_mac3.get_weight();
		_wLat = linefile.getLocation().getLat()*_pi;
		_wLon = linefile.getLocation().getLon()*_pi;
		_wAlt = linefile.getAlt()*_pi;
			 */
			for(LineFile Data_line : _line){ //for data
				List<Network> _wifi = Data_line.getNetwork();
				_wifi.sort(null);

				for(Network wifiData1 : _wifi){
					String mac1=wifiData1.getMac();
					for (Network wifiData2 : wifiInput) {
						//init 
						String mac2=wifiData2.getMac();					
						if(mac1.equals(mac2)){
							if (!hm.containsKey(mac1)){
								hm.put(mac1, new ArrayList<Algo2_line>());
							}
							algo2=new ArrayList<Algo2_line>();
							algo2.
							//hm.get(mac1).add(new comb(wifiData.getSignal(),wifiInput.get(0).Signal));
						}
						else{
							hm.get(mac1).add(new comb(wifiData.getSignal(),Parameters.NO_SIGNAL));
						}
						//}
						//Input_mac1.sort(null); Input_mac2.sort(null); Input_mac3.sort(null);
						comb.add(new Algo_2(_mac1, _mac2, _mac3));
					}
				}
					for (int i = 0; i < comb.size(); i++) {
						Algo_2 comb_line = comb.get(i);
						_pi = _mac1.get_weight()*_mac2.get_weight()*_mac3.get_weight();
						_wLat = Data_line.getLocation().getLat()*_pi;
						_wLon = Data_line.getLocation().getLon()*_pi;
						_wAlt = Data_line.getAlt()*_pi;
					}
			
				}//for data
			} //for Input
		}


		/**
		 * This function calculates the w-sum of those 3 MAC address
		 */
		public void calc_Weight(){
			double sum_wAlt = 0, sum_wLon = 0, sum_wLat = 0, sum_Weight = 0;
			for (int i=0; i < 3; i++){
				sum_wAlt += comb.get(i)._wAlt;
				sum_wLon += comb.get(i)._wLon;
				sum_wLat += comb.get(i)._wLat;
				sum_Weight += comb.get(i)._pi;
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
			//	Algo_2 a = new Algo_2(r);
			//	a.find_Mac(r, "c4:12:f5:fd:d1:94", -50, "e8:fc:af:9d:69:be", -80, "7c:b7:33:2e:76:73", -30);
			//	a.calc_Weight();
			//	System.out.println(a.getLocation().toString()+","+a.getAlt());

		}
	}
