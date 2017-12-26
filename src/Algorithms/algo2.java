package Algorithms;

import java.util.ArrayList;
import java.util.List;
import Project.LineFile;
import Project.Network;
import Project.Parameters;
import Project.Point_2D;
import Project.Records;
/**
 * This class represents functions that calculate the location of the user
 * by 3 MAC address and 3 signals
 * @author noytvili
 */
public class algo2 {

	private algo2_line _mac1,_mac2,_mac3;
	private double _pi;
	private double _wWeight,_wLat,_wLon,_wAlt;
	private double sum_wAlt,sum_wLon,sum_wLat,sum_Weight;

	public algo2(algo2_line _mac1, algo2_line _mac2, algo2_line _mac3) {
		this._mac1 = _mac1;
		this._mac2 = _mac2;
		this._mac3 = _mac3;
		_pi = _mac1.get_weight()*_mac2.get_weight()*_mac3.get_weight();
		//		_wLat = linefile.getLocation().getLat()*_pi;
		//		_wLon = linefile.getLocation().getLon()*_pi;
		//		_wAlt = linefile.getAlt()*_pi;
	}

	public void find_Mac(Records _rec, String mac1,int signal1,String mac2,int signal2, String mac3,int signal3){
		List<LineFile> _line = _rec.get_rec();
		List<algo2_line> algo1 = new ArrayList<algo2_line>();
		List<algo2_line> algo2 = new ArrayList<algo2_line>();
		List<algo2_line> algo3 = new ArrayList<algo2_line>();
		List<algo2> comb = new ArrayList<algo2>();
		for(LineFile line : _line){ 
			List<Network> _wifi = line.getNetwork();
			for(Network wifi : _wifi){
				if(wifi.getMac().equals(mac1)){
					algo1.add(new algo2_line(signal1, wifi.getSignal(),line.getAlt(),line.getLocation()));
				}
				else{
					algo1.add(new algo2_line(signal1,Parameters.getNoSignal(),line.getAlt(),line.getLocation()));
				}
				if(wifi.getMac().equals(mac2)){
					algo2.add(new algo2_line(signal2, wifi.getSignal(),line.getAlt(),line.getLocation()));
				}
				else{
					algo2.add(new algo2_line(signal2,Parameters.getNoSignal(),line.getAlt(),line.getLocation()));
				}
				if(wifi.getMac().equals(mac3)){
					algo3.add(new algo2_line(signal3, wifi.getSignal(),line.getAlt(),line.getLocation()));
				}
				else{
					algo3.add(new algo2_line(signal3,Parameters.getNoSignal(),line.getAlt(),line.getLocation()));
				}
			}
		}
		algo1.sort(null);algo2.sort(null);algo3.sort(null);
		for(int i=0; i<4;i++){
			comb.add(new algo2(algo1.get(i),algo2.get(i),algo3.get(i)));
		}
	}

	public void calc_Weight(algo2 algo){
		double alt1 = algo._mac1.get_alt();
		double alt2 = algo._mac2.get_alt();
		double alt3 = algo._mac3.get_alt();
		Point_2D m1 = algo._mac1.getLocation();
		Point_2D m2 = algo._mac2.getLocation();
		Point_2D m3 = algo._mac3.getLocation();
		sum_wAlt= alt1+alt2+alt3;
		sum_wLon=m1.getLon()+m2.getLon()+m3.getLon();
		sum_wLat=m1.getLat()+m2.getLat()+m3.getLat();
		sum_Weight = algo._mac1.get_weight()+algo._mac2.get_weight()+algo._mac3.get_weight();
	}
}