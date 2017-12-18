package Project;

import java.util.List;

/**
 * This class represets an object of algo2 line
 * @author Bar, Noy, Doriya
 *
 */
public class Algo2_line implements Comparable<Algo2_line>{

	private double _weight; 
	private int _signal,_diff;
	private double _alt;
	private Point_2D location;

	public Algo2_line(int input_signal, int list_signal){ //algo_linefile ??
		
		this._signal = list_signal;
		if(_signal <= Parameters.NO_SIGNAL){
			_diff = Parameters.DIFF_NO_SIG;
		}
		else{
			int dif = Math.abs(input_signal-list_signal);
			_diff = Math.max(dif, Parameters.MIN_DIFF);
		}
		_weight = Parameters.NORM / (Math.pow(_diff, Parameters.SIG_DIFF)*Math.pow(input_signal, Parameters.POWER));
	}
//	public Algo2_line(Point_2D location,double _alt, ){
//		
//	}

	public Network get_network(Algo_linefile A){
		return A.get_wifi();
	}
	public double get_alt() {
		return _alt;
	}

	public void set_alt(double _alt) {
		this._alt = _alt;
	}

	public Point_2D getLocation() {
		return location;
	}

	public void setLocation(Point_2D location) {
		this.location = location;
	}

	public int get_signal() {
		return _signal;
	}

	public void set_signal(int _signal) {
		this._signal = _signal;
	}

	public int get_diff() {
		return _diff;
	}

	public void set_diff(int _diff) {
		this._diff = _diff;
	}

	public double get_weight() {
		return _weight;
	}

	public void set_weight(double _weight) {
		this._weight = _weight;
	}

	@Override
	public int compareTo(Algo2_line o) {
		return Integer.compare(-this._signal, -o._signal);
	}

	public List<Network> getNetwork() {
		return null;
	}


}
