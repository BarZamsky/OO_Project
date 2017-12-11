package matala_1;
/**
 * This class represents the objects of the new Line for Algo1
 * @author Doriya , Noy, Bar
 *
 */
public class Algo1_line implements Comparable<Algo1_line> {

	private int signal;
	private double alt;
	Point_2D location;
	
	public Algo1_line(int signal, double alt, Point_2D location) {
		this.signal = signal;
		this.alt = alt;
		this.location = location;
	}

	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}

	public Point_2D getLocation() {
		return location;
	}

	public void setLocation(Point_2D location) {
		this.location = location;
	}

	@Override
	public int compareTo(Algo1_line o) {
		return Integer.compare(-this.signal, -o.signal);
	}

	@Override
	public String toString() {
		return "Algo1_line [signal=" + signal + ", alt=" + alt + ", location=" + location + "]";
	}
}
