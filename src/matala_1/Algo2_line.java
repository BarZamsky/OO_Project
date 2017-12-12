package matala_1;

public class Algo2_line implements Comparable<Algo2_line>{
	final int POWER = 2;
	final int NORM = 10000;
	final double SIG_DIFF =0.4;
	final int MIN_DIFF =3;
	final int NO_SIGNAL = -120;
	final int DIFF_NO_SIG = 100;

	private double _weight; 
	private int _signal,_diff;
	private double _alt;
	private Point_2D location;
	
	public Algo2_line(int input_signal, int list_signal){
		this._signal=list_signal;
		if(_signal<=NO_SIGNAL){
			_diff = DIFF_NO_SIG;
		}
		else{
			int dif = Math.abs(input_signal-list_signal);
			_diff = Math.max(dif, MIN_DIFF);
		}
		_weight = NORM / (Math.pow(_diff, SIG_DIFF)*Math.pow(input_signal, POWER));
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


}
