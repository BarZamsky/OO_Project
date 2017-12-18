package Project;
import java.util.ArrayList;


public class comb {
	private double _pi;
	private double _alt;
	private Point_2D p;
	private ArrayList<Algo2_line> diff_w;
    
//    public comb(){
//    	this._alt=_alt;
//    	this.p=p;
//    	this.diff_w=diff_w;
//
//    }
    public comb(Point_2D p, double _alt, ArrayList<Algo2_line> diff_w,  double _pi){
    	this.p=p;
    	this.diff_w=diff_w;
    	this._alt=_alt;
    	this._pi=_pi;
    }

	public double get_pi() {
		return _pi;
	}

	public void set_pi(double _pi) {
		this._pi = _pi;
	}

	public double get_alt() {
		return _alt;
	}

	public void set_alt(double _alt) {
		this._alt = _alt;
	}

	public Point_2D getP() {
		return p;
	}

	public void setP(Point_2D p) {
		this.p = p;
	}

	public ArrayList<Algo2_line> getDiff_w() {
		return diff_w;
	}

	public void setDiff_w(ArrayList<Algo2_line> diff_w) {
		this.diff_w = diff_w;
	}
}
