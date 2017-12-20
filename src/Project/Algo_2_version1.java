package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class represents the main class for algo2
 * @author Bar, Noy, Doriya
 */
public class Algo_2_version1 {
	private Algo2_line _mac1;
	private Algo2_line _mac2;
	private Algo2_line _mac3;
	private List<LineFile> _file;
	private ArrayList<Algo2_line> algo2;
	private double _pi;
	private double _wLat,_wLon,_wAlt;
	private double w_alt, w_lon, w_lat;

//	public Algo_2(Records Data, Records Input){
//		Data = new Records();
//		Input = new Records();
//	}
	public Algo_2_version1(List<List<comb>> a) { //we need to get n 
for(int i=0;i<a.size();i++){
	List<comb> cm = a.get(i);
	for(comb b : cm){
		_pi *= b.g;
	}
_wLat = data.getLocation().getLat()*_pi;
_wLon = data.getLocation().getLon()*_pi;
_wAlt = data.getAlt()*_pi;
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
	public void find_Mac(List<LineFile> Data, List<LineFile> Input, int n){
		HashMap<String,List<Algo_2>> hm=new HashMap<String,List<Algo_2>>();  

		List<Algo2_line> Input_line = new ArrayList<Algo2_line>();
		for (Algo2_line line : Input_line) {//for input
			List<Network> wifiInput = line.getNetwork(); //לבדוק את  getNetwork
			wifiInput.sort(null);

			/* 		
		
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

		public List<LineFile> readFile(String fileName){
			List<LineFile> list = new ArrayList<LineFile>();
			try{
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line="";
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
					net.sort(null);
					list.add(new LineFile(time,str[1],point,Double.parseDouble(str[4]),Integer.parseInt(str[5]), net));
				}
				br.close();
			}
			catch(IOException ex) {
				System.out.print("Error reading file\n" + ex);
				System.exit(2);
			}
			return list;
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
