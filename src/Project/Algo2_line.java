package Project;

/**
 * This class represents an object of algo2 line
 * @author Bar, Noy, Doriya
 *
 */
public class Algo2_line implements Comparable<Algo2_line>{
	private double _weight; 
	private int _signal,_diff;
	private Point_2D _p;
	private double alt;

	public Algo2_line(LineFile l,int input_signal, int list_signal){ //algo_linefile ??
		this._signal = list_signal;
		if(_signal <= Parameters.NO_SIGNAL){
			_diff = Parameters.DIFF_NO_SIG;
		}
		else{
			int dif = Math.abs(input_signal-(list_signal));
			_diff = Math.max(dif,Parameters.MIN_DIFF);
		}
		_weight = Parameters.NORM/(Math.pow(_diff, Parameters.SIG_DIFF)*Math.pow(input_signal, Parameters.POWER));
		_p = l.getLocation();
		alt = l.getAlt();
	}

	public Algo2_line(String string) {
		string=null;
	}

	public Point_2D get_p() {
		return _p;
	}

	public void set_p(Point_2D _p) {
		this._p = _p;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
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

	@Override
	public String toString() {
		return "Algo2_line [_weight=" + _weight + ", _signal=" + _signal + ", _diff=" + _diff + "]";
	}

}
