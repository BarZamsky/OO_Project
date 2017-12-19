package Project;

public class comb implements Comparable<comb>{
	private double _pi;
	private double _alt;
	private Point_2D _point;
    
	public comb(){};
	
    public comb(Point_2D point, double alt,double pi){
    	this._point=point;
    	this._alt=alt;
    	this._pi = pi;
   }

	public double get_pi() {
		return _pi;
	}

	public void set_pi(double _pi) {
		this._pi = _pi;
	}

	public void set_point(Point_2D _point) {
		this._point = _point;
	}

	public Point_2D get_point() {
		return _point;
	}

	public double get_alt() {
		return _alt;
	}

	public void set_alt(double _alt) {
		this._alt = _alt;
	}

	@Override
	public int compareTo(comb o) {
		return Double.compare(-this._pi, -o._pi);
	}

	@Override
	public String toString() {
		return "comb [_pi=" + _pi + ", _alt=" + _alt + ", _point=" + _point + "]";
	}
	
}
