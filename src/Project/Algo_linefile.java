package Project;
/**
 * This class creates linefile for Algo1 
 * @author Bar, Noy ,Doriya
 *
 */
public class Algo1_linefile {
private Time _time;
private Point_2D _location;
private double _alt;
private Network _wifi;

public Algo1_linefile(Time _time, Point_2D _location, double _alt, Network _wifi) {
	this._time = _time;
	this._location = _location;
	this._alt = _alt;
	this._wifi = _wifi;
}

public Time get_time() {
	return _time;
}

public void set_time(Time _time) {
	this._time = _time;
}

public Point_2D get_location() {
	return _location;
}

public void set_location(Point_2D _location) {
	this._location = _location;
}

public double get_alt() {
	return _alt;
}

public void set_alt(double _alt) {
	this._alt = _alt;
}

public Network get_wifi() {
	return _wifi;
}

public void set_wifi(Network _wifi) {
	this._wifi = _wifi;
}
@Override
public String toString() {
	return  _wifi+","+ _location+","+_alt+","+_time;
}

}
