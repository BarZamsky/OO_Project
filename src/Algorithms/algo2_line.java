package Algorithms;

import Project.Parameters;
import Project.Point_2D;
/**
 * This class represents the objects of the new Line for algo2
 * @author Noy, Bar, Doriya
 *
 */
public class algo2_line implements Comparable<algo2_line> {
	private double _weight; 
	private int _signal,_diff;
	private double _alt;
	private Point_2D location;

	public algo2_line(int input_signal, int list_signal,double _alt,Point_2D location){
		this._signal=list_signal;
		if(list_signal==Parameters.getNoSignal()){
			this._diff = Parameters.getDiffNoSig();
		}
		else{
			this._diff = Math.abs(input_signal-list_signal);
		}
		_weight = Parameters.getNorm() / Math.pow(_diff, Parameters.getSigDiff()*Math.pow(input_signal, Parameters.getPower()));
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
	public int compareTo(algo2_line o) {
		return Integer.compare(-this._signal, -o._signal);
	}
}
