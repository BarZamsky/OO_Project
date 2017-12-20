package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents functions that read comb CSV and no GPS CSV,
 * calculate and return to the Input file the user location
 * @author Noy, Bar, Doriya
 *
 */
public class Algo_2 {

	private List<List<Algo2_line>> _list; // the excel list for all MAC
	private List<comb> _comb; //combined list for the final calculates
	private double _alt; 
	private Point_2D _point;
	private double w_alt=0, w_lon=0, w_lat=0;
	
/**
* This function go over the Input list and search every MAC address in the Data list 
*/
	public void combine(List<LineFile> input, List<LineFile> data){
		for(LineFile line_input : input){
			_list = new ArrayList<List<Algo2_line>>();
			_comb = new ArrayList<comb>();
			List<Network> n = line_input.getNetwork();
			for(Network net : n){
				List<Algo2_line> l = new ArrayList<Algo2_line>();
				String mac_input = net.getMac();
				for(LineFile line_data : data){
					_alt = line_data.getAlt();
					_point = new Point_2D(line_data.getLocation().getLon(), line_data.getLocation().getLat());
					List<Network> _wifi = line_data.getNetwork();
					for(Network wifi : _wifi){
						if(wifi.getMac().equals(mac_input)){
							Algo2_line al = new Algo2_line(net.getSignal(), wifi.getSignal());
							l.add(al);
						}
						else{
							Algo2_line al =new Algo2_line(net.getSignal(),Parameters.NO_SIGNAL);
							l.add(al);
						}
					}
				}
				_list.add(l);
			}
//			for(List<Algo2_line> list : _list){
//				System.out.println(list.toString());
//			}
			for(List<Algo2_line> list : _list){
				double pi = 1;
				for(Algo2_line line : list){
					//System.out.println(line.get_weight());
					pi*=line.get_weight();
				//	System.out.println(pi);
				}
				_comb.add(new comb(_point,_alt,pi));
			}
			_comb.sort(null);
//			for(comb c : _comb){
//				System.out.println(c.toString());
//			}
			calc_Weight();
			line_input.setAlt(w_alt);
			line_input.setLocation(new Point_2D(w_lon, w_lat));
		}
//		for(LineFile l : input){
//			System.out.println(l.toString());
//		}
	}
	/**
	 * this function calculate the wLat,wLon,wAlt according to the demands
	 * and the final w_alt, w_lat, w_lon to create a new location
	 */
	public void calc_Weight(){
		double sum_wAlt = 0, sum_wLon = 0, sum_wLat = 0, sum_Weight = 0;
		//System.out.println(_comb.size());
		for (int i=0; i < Math.min(3, _comb.size()); i++){
			sum_wAlt += _comb.get(i).get_alt()*_comb.get(i).get_pi();
			sum_wLon += _comb.get(i).get_point().getLon()*_comb.get(i).get_pi();
			sum_wLat += _comb.get(i).get_point().getLat()*_comb.get(i).get_pi();
			sum_Weight+= _comb.get(i).get_pi();
		}
		w_alt=sum_wAlt/sum_Weight;
		w_lon=sum_wLon/sum_Weight;
		w_lat=sum_wLat/sum_Weight;
	}
	/**
	 * Reading from no GPS file.
	 * @param fileName
	 * @return
	 */
	public List<LineFile> readFile(String fileName){
		List<LineFile> list = new ArrayList<LineFile>();
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line="";
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				List<Network> net = new ArrayList<Network>();
				Time time = new Time();
				time = time.set_Date(str[0]);
				for(int i=6;i<str.length;i+=4){
					Network n = new Network(str[i], str[i+1], Integer.parseInt(str[i+3]), str[i+2]);
					net.add(n);
				}
				net.sort(null);
				if(str[2].equals("?") ||str[3].equals("?") ||str[4].equals("?")){
					Point_2D point = new Point_2D(0,0);
					double alt = 0;
					list.add(new LineFile(time,str[1],point,alt,Integer.parseInt(str[5]), net));
				}
				else{
				Point_2D point = new Point_2D(Double.parseDouble(str[2]),Double.parseDouble(str[3]));
				double alt =Double.parseDouble(str[4]);
				list.add(new LineFile(time,str[1],point,alt,Integer.parseInt(str[5]), net));
				}
			}
			fr.close();
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Errorg reading file\n" + ex);
			System.exit(2);
		}
		return list;
	}
	/**
	 * Reading from comb file
	 * @param fileName
	 * @return
	 */
	public List<LineFile> readFile2(String fileName){
		List<LineFile> list = new ArrayList<LineFile>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line="";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				//System.out.println(line);
				List<Network> net = new ArrayList<Network>();
				Point_2D point = new Point_2D(Double.parseDouble(str[2]),Double.parseDouble(str[3]));
				Time time = new Time();
				time = time.set_Date(str[0]);
				for(int i=6;i<str.length;i+=4){
					Network n = new Network(str[i], str[i+1], Integer.parseInt(str[i+2]), str[i+3]);
					net.add(n);
				}
				list.add(new LineFile(time,str[1],point,Double.parseDouble(str[4]),Integer.parseInt(str[5]), net));
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error Algo2 reading comb file\n" + ex);
			System.exit(2);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Algo_2 a = new Algo_2();
		List<LineFile> input = a.readFile("C:/Users/noytvili/Desktop/testing2/_comb_no_gps_ts2_.csv");
		List<LineFile> data =a.readFile2("C:/Users/noytvili/Desktop/testing2/_comb_all_BM3_.csv");
		a.combine(input, data);
	}
}
