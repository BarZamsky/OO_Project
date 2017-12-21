package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents functions that read comb CSV and no GPS CSV,
 * calculate Algo2 and return to the Input file the user location
 * @author Noy, Bar, Doriya
 *
 */
public class Algo_2 implements Functions{
	static final int NO_SIGNAL = -120;
	private List<List<Algo2_line>> _list; // the excel list for all MAC
	private List<Algo2_calc> _comb; //combined list for the final calculates
	private List<LineFile> _input;
	private List<LineFile> _data;
	private double _alt; 
	private Point_2D _point;;
	private double w_alt, w_lon, w_lat;

	/**
	 * This function go over the Input list and search every MAC address in the Data list
	 * return the new location in the Input file
	 */
	public void search_Mac(){
		boolean exist=false;
		for(LineFile line_input : _input){
			_list = new ArrayList<List<Algo2_line>>();
			_comb = new ArrayList<Algo2_calc>();
			List<Network> n = line_input.getNetwork();
			for(Network net : n){
				List<Algo2_line> l = new ArrayList<Algo2_line>();
				String mac_input = net.getMac();
				for(LineFile line_data : _data){
					List<Network> _wifi = line_data.getNetwork();
					for(Network wifi : _wifi){
						if(wifi.getMac().equals(mac_input)){
							Algo2_line al = new Algo2_line(line_data,net.getSignal(), wifi.getSignal());
							l.add(al);
						}
						else{
							for(LineFile line_data_Null : _data){ //for to check null
								List<Network> _wifi_Null = line_data.getNetwork();

								for(Network wifi_null : _wifi_Null){

									while(line_data_Null!=null){
										
										if(wifi_null.getMac().equals(mac_input)){
											exist=true;
										}
										else exist=false;
									}
									if(exist) {
										Algo2_line al =new Algo2_line(line_data,net.getSignal(),NO_SIGNAL);
										l.add(al);
									}
									else {
										Algo2_line al =new Algo2_line("null");
										l.add(al);
									}

									
								}
								
							}
							
						}
						
					}
				}
				_list.add(l);
			}
			int wifi_Number = _list.size();// the List<List> size
			int list_size = _list.get(0).size();//each list size

			for(int j=0;j<list_size;j++){
				double pi = 1.0;
				for(int i =0;i<wifi_Number;i++){
					List<Algo2_line> ls = _list.get(i);
					Algo2_line alg = ls.get(j);
					pi*=alg.get_weight();
					_point = alg.get_p();
					_alt = alg.getAlt();
				}
				_comb.add(new Algo2_calc(_point,_alt,pi));
			}
			_comb.sort(null);
			calc_Weight();
			line_input.setAlt(w_alt);
			line_input.setLocation(new Point_2D(w_lon, w_lat));
		}
	}

	/**
	 * this function calculate the wLat,wLon,wAlt according to the demands
	 * and the final w_alt, w_lat, w_lon to create a new location
	 */
	public void calc_Weight(){
		double sum_wAlt = 0, sum_wLon = 0, sum_wLat = 0, sum_Weight = 0;
		for (int i=0; i < 3 && i<_comb.size(); i++){
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
	 * @return List
	 */
	@Override
	public void readFile(String fileName){
		_input = new ArrayList<LineFile>();
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
					_input.add(new LineFile(time,str[1],point,alt,Integer.parseInt(str[5]), net));
				}
				else{
					Point_2D point = new Point_2D(Double.parseDouble(str[2]),Double.parseDouble(str[3]));
					double alt =Double.parseDouble(str[4]);
					_input.add(new LineFile(time,str[1],point,alt,Integer.parseInt(str[5]), net));
				}
			}
			fr.close();
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Errorg reading file\n" + ex);
			System.exit(2);
		}
	}
	/**
	 * Reading from merge input file (my merge file not boaz)
	 * @param fileName
	 */
	public void readFile2(String fileName){
		_data = new ArrayList<LineFile>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line=""; 
			br.readLine();   
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				List<Network> net = new ArrayList<Network>();
				Point_2D point = new Point_2D(Double.parseDouble(str[2]),Double.parseDouble(str[3]));
				Time time = new Time();
				time = time.set_Date(str[0]);
				for(int i=6;i<str.length;i+=4){ 
					Network n = new Network(str[i], str[i+1], Integer.parseInt(str[i+2]), str[i+3]);
					net.add(n);
				} 
				_data.add(new LineFile(time,str[1],point,Double.parseDouble(str[4]),Integer.parseInt(str[5]), net));
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error Algo2 reading comb file\n" + ex);
			System.exit(2);
		}
	}

	/**
	 * This function writes the new csv file
	 * @param output output csv file name
	 */
	@Override
	public void toCsv(String output){
		try{
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			for(LineFile l : _input){
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
		Algo_2 a = new Algo_2();
		a.readFile("_comb_no_gps_ts2_.csv");
		a.readFile2("_comb_all_BM3_.csv");
		a.search_Mac();
		a.toCsv("complete_File.csv");
	}
}
